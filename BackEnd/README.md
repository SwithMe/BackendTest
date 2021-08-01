[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FSwithMe%2FSwitMe%2Ftree%2Fdevelop%2FBackEnd&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)<br/>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/AWS RDS-FF9900?style=for-the-badge&logo=AmazonAWS&logoColor=white">
<img src="https://img.shields.io/badge/AWS EC2-FF9900?style=for-the-badge&logo=AmazonAWS&logoColor=white">
<img src="https://img.shields.io/badge/AWS S3-FF9900?style=for-the-badge&logo=AmazonAWS&logoColor=white">
<img src="https://img.shields.io/badge/STOMP-FA5C5C?style=for-the-badge&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white">

<br>


<p align="center"><img src="https://user-images.githubusercontent.com/55133794/127760251-3263fb22-a891-4038-8dfc-cb9594c91174.png" width="300"></p>


> `온오프라인 스터디팟`을 구하고 `스톱워치` 기능을 통해 자신의 공부시간을 측정, 공유함으로써 공부에 동기 부여를 제공하는 서비스의 백엔드 리포지토리입니다.


<br>

## 💡 팀원 및 역할 분담

|[@Jungeunkim-dev](https://github.com/Jungeunkim-dev)|[@hyojin530](https://github.com/hyojin530)|[@Inryu](https://github.com/Inryu)|[@yhjune](https://github.com/yhjune)|
|------|---|---|---|
|• 회원가입/로그인 <br> • 스터디 목록 |• 채팅 기능 </br> • 마이페이지 </br> • 스터디 멤버 목록 페이지 |• 메인 페이지 </br> • 스톱워치 페이지| • 스터디 화면(생성 수정 탈퇴 가입)



## 💡 기술 스택

- Spring Boot
- MySQL
- JPA
- Spring Security
- AWS RDS
- AWS EC2
- AWS S3
- STOMP(WebSocket Protocol)



## 💡 ERD

![switme_20210801_47_44](https://user-images.githubusercontent.com/55133794/127760820-95ec15c2-235a-4718-adb0-cfc3441d397c.png)


## 💡 API 명세서

- [🔗 link](https://six-sapphire-eb2.notion.site/API-86c2c2fa669a430eb97669b3b13cfa30)

## 💡 프로젝트 구조
```
📦switme
 ┣ 📂config
 ┃ ┣ 📜CustomAuthenticationFilter.java
 ┃ ┣ 📜CustomAuthenticationProvider.java
 ┃ ┣ 📜HeaderFilter.java
 ┃ ┣ 📜JwtTokenInterceptor.java
 ┃ ┣ 📜SwaggerConfig.java
 ┃ ┣ 📜WebMvcConfig.java
 ┃ ┣ 📜WebSecurityConfig.java
 ┃ ┗ 📜WebSocketConfig.java
 ┣ 📂controller
 ┃ ┣ 📜ChatController.java
 ┃ ┣ 📜ChatRoomController.java
 ┃ ┣ 📜CustomLoginSuccessHandler.java
 ┃ ┣ 📜EmailController.java
 ┃ ┣ 📜ErrorController.java
 ┃ ┣ 📜ExceptionController.java
 ┃ ┣ 📜MemberController.java
 ┃ ┣ 📜MyPageController.java
 ┃ ┣ 📜StudyController.java
 ┃ ┣ 📜TimerController.java
 ┃ ┣ 📜TimerDailyController.java
 ┃ ┣ 📜TimerLogController.java
 ┃ ┗ 📜UserController.java
 ┣ 📂domain
 ┃ ┣ 📜AuthConstants.java
 ┃ ┣ 📜ChatMessage.java
 ┃ ┣ 📜ChatRoom.java
 ┃ ┣ 📜MyUserDetails.java
 ┃ ┣ 📜Study.java
 ┃ ┣ 📜Timer.java
 ┃ ┣ 📜TimerDailyStudy.java
 ┃ ┣ 📜TimerDailyUser.java
 ┃ ┣ 📜TimerLog.java
 ┃ ┣ 📜User.java
 ┃ ┣ 📜UserDataExtra.java
 ┃ ┣ 📜UserRole.java
 ┃ ┣ 📜UserStudy.java
 ┃ ┣ 📜UserYesOrNo.java
 ┃ ┗ 📜new.txt
 ┣ 📂dto
 ┃ ┣ 📜ChatMessageDto.java
 ┃ ┣ 📜ChatMessageInterface.java
 ┃ ┣ 📜ChatRoomDto.java
 ┃ ┣ 📜CumulativeTimeDto.java
 ┃ ┣ 📜DisconnectDto.java
 ┃ ┣ 📜JoinStudyDto.java
 ┃ ┣ 📜JoinStudyRequestDto.java
 ┃ ┣ 📜LoginDto.java
 ┃ ┣ 📜MakeRoomDto.java
 ┃ ┣ 📜MakeRoomLeaderDto.java
 ┃ ┣ 📜MakeRoomResponseDto.java
 ┃ ┣ 📜MakeStudyDto.java
 ┃ ┣ 📜MemberResponseDto.java
 ┃ ┣ 📜MessageListResponseDto.java
 ┃ ┣ 📜RecomStudyResDto.java
 ┃ ┣ 📜RoomListResponseDto.java
 ┃ ┣ 📜SaveTimerRequestDto.java
 ┃ ┣ 📜SearchResultDto.java
 ┃ ┣ 📜SearchStudyDto.java
 ┃ ┣ 📜SignUpDTO.java
 ┃ ┣ 📜SocketDto.java
 ┃ ┣ 📜SuccessResponseDto.java
 ┃ ┣ 📜TimerCreateRequestDto.java
 ┃ ┣ 📜TimerDailyStudySaveDto.java
 ┃ ┣ 📜TimerDailyUserSaveDto.java
 ┃ ┣ 📜TimerListResDto.java
 ┃ ┣ 📜TimerLogSaveDto.java
 ┃ ┣ 📜TimerRankDto.java
 ┃ ┣ 📜TimerSaveDto.java
 ┃ ┣ 📜TimerStudyCreateRequestDto.java
 ┃ ┣ 📜UserInfoResponseDto.java
 ┃ ┣ 📜UserListResponseDTO.java
 ┃ ┣ 📜UserStudyListResponseDto.java
 ┃ ┣ 📜UserTimerLogResponseDto.java
 ┃ ┣ 📜UserUpdateDto.java
 ┃ ┣ 📜WarningDto.java
 ┃ ┗ 📜showStudyDto.java
 ┣ 📂exception
 ┃ ┣ 📜InputNotFoundException.java
 ┃ ┣ 📜NoResultFromDBException.java
 ┃ ┗ 📜UserNotFoundException.java
 ┣ 📂repository
 ┃ ┣ 📜ChatMessageRepository.java
 ┃ ┣ 📜ChatRoomRepository.java
 ┃ ┣ 📜EmailUserService.java
 ┃ ┣ 📜StudyRepository.java
 ┃ ┣ 📜TimerDailyStudyRepository.java
 ┃ ┣ 📜TimerDailyUserRepository.java
 ┃ ┣ 📜TimerLogRepository.java
 ┃ ┣ 📜TimerRepository.java
 ┃ ┣ 📜UserDataExtraRepository.java
 ┃ ┣ 📜UserRepository.java
 ┃ ┗ 📜UserStudyRepository.java
 ┣ 📂service
 ┃ ┣ 📜ChatMessageService.java
 ┃ ┣ 📜ChatRoomService.java
 ┃ ┣ 📜EmailService.java
 ┃ ┣ 📜MyPageService.java
 ┃ ┣ 📜StudyService.java
 ┃ ┣ 📜TimerDailyStudyService.java
 ┃ ┣ 📜TimerDailyUserService.java
 ┃ ┣ 📜TimerLogService.java
 ┃ ┣ 📜TimerService.java
 ┃ ┣ 📜TokenUtils.java
 ┃ ┣ 📜UserDetailsServiceImpl.java
 ┃ ┣ 📜UserService.java
 ┃ ┗ 📜UserStudyService.java
 ┗ 📜SwitmeApplication.java

 ```
