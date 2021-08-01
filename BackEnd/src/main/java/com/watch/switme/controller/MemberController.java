package com.watch.switme.controller;

import com.watch.switme.dto.MemberResponseDto;
import com.watch.switme.dto.SuccessResponseDto;
import com.watch.switme.dto.WarningDto;
import com.watch.switme.service.UserStudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/study/members")
public class MemberController {
    private final UserStudyService userStudyService;

    @GetMapping("/{study_idx}")
    public List<MemberResponseDto> getStudyMember(@PathVariable("study_idx") Long study_idx){
        return userStudyService.getMemberList(study_idx);
    }

    @PostMapping("/warning")
    public SuccessResponseDto warningMember(@RequestBody WarningDto warningDto){
        try{
            userStudyService.updateWarning(warningDto.getStudy_idx(), warningDto.getUser_idx());
        } catch (Exception e){
            System.out.println(e);
            return SuccessResponseDto.builder().success(false).build();
        }

        return SuccessResponseDto.builder().success(true).build();
    }
}
