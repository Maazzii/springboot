# springboot
## 개요
**스프링 부트와 AWS로 혼자 구현하는 웹 서비스 (이동욱 저)** 책을 보고 공부하며 만든 간단한 웹 애플리케이션이다.

springboot, JPA, AWS EC2, S3, CodeDeploy, travis⋯.<br>
그저 spring framework와 myBatis를 이용해서 제작하고 localhost에서만 구동하던 내가 새로운 기술과 용어가 굉장히 많아서 공부하는 보람이 있었다.

이 프로젝트는 스프링부트 환경에서 제작되었으며,<br>
travis가 설치되어 있어 GitHub에 변경 내용을 Push하면 자동으로 빌드되고,<br>
AWS CodeDeploy를 통해 EC2에 자동으로 배포까지 완료된다.<br>

OAuth 2.0을 이용해 소셜 로그인을 구현하였으며, 교재에 나와 있지 않은 카카오 로그인은 스스로 구현하였다.

[웹 페이지 링크](http://ec2-15-165-87-43.ap-northeast-2.compute.amazonaws.com/)
