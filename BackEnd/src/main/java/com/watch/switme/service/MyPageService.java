package com.watch.switme.service;

import com.watch.switme.domain.TimerLog;
import com.watch.switme.domain.User;
import com.watch.switme.domain.UserDataExtra;
import com.watch.switme.domain.UserStudy;
import com.watch.switme.dto.UserStudyListResponseDto;
import com.watch.switme.dto.UserTimerLogResponseDto;
import com.watch.switme.dto.UserUpdateDto;
import com.watch.switme.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MyPageService {
    private final UserRepository userRepository;
    private final UserDataExtraRepository userDataExtraRepository;
    private final UserStudyRepository userStudyRepository;
    private final TimerLogRepository timerLogRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final S3Service s3Service;

    @Transactional
    public List<UserStudyListResponseDto> getUserStudyList(Long user_idx) {
        List<UserStudy> userStudyList = userStudyRepository.findByUserIdx(user_idx);
        List<UserStudyListResponseDto> userStudyListResponseDtoList = new ArrayList<>();

        for(UserStudy study: userStudyList){
            UserStudyListResponseDto userStudyListResponseDto = UserStudyListResponseDto.builder()
                    .study_idx(study.getStudy().getStudy_idx())
                    .study_title(study.getStudy().getTitle())
                    .study_image(study.getStudy().getImage())
                    .start_date(study.getStudy().getTermstart())
                    .end_date(study.getStudy().getTermend())
                    .warning(study.getWarning())
                    .activate(study.getStudy().getActivate())
                    .build();

            userStudyListResponseDtoList.add(userStudyListResponseDto);
        }

        return userStudyListResponseDtoList;
    }

    @Transactional
    public List<UserTimerLogResponseDto> getUserTimerLog(Long user_idx){
        List<UserTimerLogResponseDto> userTimerLogResponseDtoList = new ArrayList<>();
        List<TimerLog> timerLogList = timerLogRepository.findTop20ByUserIdx(user_idx);

        for(TimerLog timerLog: timerLogList){
            UserTimerLogResponseDto userTimerLogResponseDto = UserTimerLogResponseDto.builder()
                    .log_idx(timerLog.getLog_idx())
                    .start_time(timerLog.getStart_time())
                    .end_time(timerLog.getEnd_time())
                    .duration(timerLog.getDuration())
                    .build();

            userTimerLogResponseDtoList.add(userTimerLogResponseDto);
        }

        return userTimerLogResponseDtoList;
    }

    @Transactional
    public void updateUser(UserUpdateDto userUpdateDto) throws Exception{
        Long user_idx = userUpdateDto.getUser_idx();
        User user = userRepository.findFirstByUserIdx(user_idx);

        if(userUpdateDto.getPassword() != null){
            String new_password = bCryptPasswordEncoder.encode(userUpdateDto.getPassword());
            System.out.println(new_password);
            user.setPw(new_password);
            //userRepository.save(user);
        }

        if(userUpdateDto.getFile() != null){
            UserDataExtra userDataExtra = userDataExtraRepository.findFirstByUserIdx(user_idx);
            MultipartFile file = userUpdateDto.getFile();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String current_date = simpleDateFormat.format(System.currentTimeMillis());

            String file_name = current_date+file.getOriginalFilename();;
            String file_url = s3Service.upload(file, file_name);

            if(userDataExtra == null){
                userDataExtraRepository.save(UserDataExtra.builder()
                        .userIdx(user_idx)
                        .selfImage(file_url)
                        .build());
            } else {
                userDataExtra.updateUserImage(file_url);
            }

        }

    }

}
