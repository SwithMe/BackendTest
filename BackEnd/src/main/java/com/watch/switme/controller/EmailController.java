package com.watch.switme.controller;

import com.watch.switme.domain.User;
import com.watch.switme.dto.LoginDto;
import com.watch.switme.dto.SignUpDTO;
import com.watch.switme.repository.UserRepository;
import com.watch.switme.service.EmailService;
import com.watch.switme.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController

public class EmailController {
    @Autowired
    private final EmailService emailService;

    @Autowired
    private final UserRepository userRepository;

    @PostMapping(value="/user/email/find")
    public void findMail(@RequestBody  SignUpDTO signUpDTO) throws MessagingException{
        User user=userRepository.findByEmailAndRealname(signUpDTO.getEmail(), signUpDTO.getRealname());
        StringBuffer emailcontent = new StringBuffer();
        emailcontent.append("<!DOCTYPE html>");
        emailcontent.append("<html>");
        emailcontent.append("<head>");
        emailcontent.append("</head>");
        emailcontent.append("<body>");
        emailcontent.append(
                " <div" 																																																	+
                        "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"		+
                        "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"																															+
                        "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">FIND</span><br />"																													+
                        "		<span style=\"color: #006400\">SWITME 비밀번호안내</span>"																																				+
                        "	</h1>\n"																																																+
                        "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
                        +
                       ""																																						+
                        user.getRealname()+"님의 비밀번호는"+user.getPw()+"입니다."+
                        "	</p>"																																																	+

                        ""						+


                        "	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>"																																		+
                        " </div>"
        );
        emailcontent.append("</body>");
        emailcontent.append("</html>");
        emailService.sendMail(signUpDTO.getEmail(), emailcontent.toString());
    }

    @PostMapping(value="/user/email/send")
    public void sendMail(@RequestBody SignUpDTO signUpDTO) throws MessagingException{
        System.out.println(signUpDTO.getEmail());

        String email=signUpDTO.getEmail();
        String pw=signUpDTO.getPw();
        String realname=signUpDTO.getRealname();

        StringBuffer emailcontent = new StringBuffer();
        emailcontent.append("<!DOCTYPE html>");
        emailcontent.append("<html>");
        emailcontent.append("<head>");
        emailcontent.append("</head>");
        emailcontent.append("<body>");
        emailcontent.append(
                " <div" 																																																	+
                        "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"		+
                        "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"																															+
                        "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">WELCOME</span><br />"																													+
                        "		<span style=\"color: #006400\">스윗미 메일인증</span> 안내입니다."																																				+
                        "	</h1>\n"																																																+
                        "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
                        +
                        realname																																							+
                        "		님 안녕하세요.<br />"																																													+

                        "		<b style=\"color: #02b875\">'메일 인증'</b> 버튼을 클릭하여 회원가입을 완료해 주세요.<br />"																													+
                        "		감사합니다."																																															+
                        "	</p>"																																																	+
                        "	<a style=\"color: #FFF; text-decoration: none; text-align: center;\""																																	+
                        "	href=\"http://localhost:8080/auth/signup/"+ email +"/"+ pw +"/"+realname+"\" target=\"_blank\">"														+
                        "		<p"																																																	+
                        "			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #02b875; line-height: 45px; vertical-align: middle; font-size: 16px;\">"							+
                        "			메일 인증</p>"																																														+
                        "	</a>"																																																	+
                        "	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>"																																		+
                        " </div>"
        );
        emailcontent.append("</body>");
        emailcontent.append("</html>");
        emailService.sendMail(email, emailcontent.toString());
    }
}
