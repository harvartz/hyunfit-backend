# 사내 헬스 케어 복지 서비스, Hyunfit

<!-- 목차 -->
<details>
  <summary>목차</summary>
  <ol>
    <li><a href="#1-서비스-실행">서비스 실행</a></li>
    <li>
        <a href="#2-프로젝트-소개">프로젝트 소개</a>
        <ul>
            <li>1) 프로젝트 주제</li>
            <li>2) 서비스 개요 및 배경</li>
            <li>3) 서비스 목표</li>
        </ul>
    </li>
    <li>
        <a href="#3-서비스-기능-소개">서비스 기능 소개</a>
        <ul>
            <li>1) 메인 기능</li>
            <li>2) 서브 기능</li>
            <li>3) 관련 문서</li>
        </ul>
    </li>
    <li>
        <a href="#4-사용된-데이터셋과-기술스택">사용된 데이터셋과 기술스택</a>
        <ul>
            <li>1) 어떤 데이터셋을 어떻게 전처리하고 사용할것인지</li>
            <li>2) 어떤 방법, 라이브러리나 알고리즘을 사용할것인지</li>
        </ul>
    </li>
    <li>
        <a href="#5-시스템-아키텍쳐">시스템 아키텍쳐</a>
        <ul>
            <li>1) 개발 구조</li>
        </ul>
    </li>
    <li><a href="#6-프로젝트-팀원-소개">프로젝트 팀원 소개</a></li>
  </ol>
</details>

<h2 id="1-서비스-실행">1. 서비스 실행</h2>

* Android (API Level 33 이상)

1. git clone
```
git clone https://github.com/kinopioB/EatGo-Frontend.git
```
2. 실행  
Android Studio Project Open -> File -> Sync Project with Gradle Files -> Run app

* Back-End (STS 기준)
1. git clone
```
git clone https://github.com/kinopioB/EatGo-Backend.git
```
2. Server Tomcat v9.0 추가  
Servers -> New -> Server -> Apache -> Tomcat v9.0 Server선택 -> Finish
3. Maven Update  
Project -> Maven -> Update Project
4. Start the server

<h2 id="2-프로젝트-소개">2. 프로젝트 소개</h2>

---
### 2-1) 프로젝트 주제
‘Hyunfit’은 건강의 중요성을 인식하고 있지만 건강 관리를 하지 못하고 있는 임직원들을 위해, 회사에서 건강한 사내 운동 문화를 만들어 임직원들의 건강 관리에 도움을 주는 사내 헬스케어 웹 서비스이다. 


### 2-2) 서비스 개요 및 배경
다수의 직장인들은 운동을 하고 싶지만 어떻게 시작해야 할지 모르고 시간적 여유가 부족한 경우가 많다. 이에 ‘Hyunfit’은 집에서도 편리하게 운동을 시작할 수 있도록 홈 트레이닝 환경을 제공하여 시간적 여유가 없는 직장인들에게 도움을 준다. AI 모션 인식 기술을 활용하여 사용자의 운동 자세를 교정하고, 화상 채팅 클래스와 전문가의 지도를 통해 더 나은 운동 경험을 제공한다. 또한 운동 기록을 분석한 리포트를 제공하여 사용자의 운동 성과에 대해서 가시적으로 확인할 수 있으며, 시간을 효과적으로 활용할 수 있게 지원한다.

### 2-3) 서비스 목표
‘Hyunfit’을 통해서 사내에서 임직원들이 건강한 라이프 스타일을 추구할 수 있도록 환경을 제공할 수 있게 도와주는 웹 서비스이다

* 주 사용자 : 사내 임직원, 사내 관리자, 헬스 트레이너

<h2 id="3-서비스-기능-소개">3. 서비스 기능 소개</h2>

---

### 3-1) 메인 기능
* 푸드트럭 검색
  * 등록된 가게 전체 조회
  * 특정 필터를 적용한 가게 검색 기능
  * 가게 히스토리 검색
* 가게 등록
  * 사장님이 자신의 가게 정보(영업 위치, 영업 시간, 메뉴)를 직접 등록 가능
  * 소비자가 자신이 이용한 가게의 위치, 영업 시간과 같은 정보를 등록 가능
* 리뷰 등록
  * 사장님이 리뷰를 위한 QR 코드 생성 가능
  * 생성한 QR 코드를 소비자가 스캔해 가게에 대한 리뷰 등록 가능
  * 리뷰 등록시 가게 정보를 등록한 사장님에게 알림


### 3-2) 서브 기능
* 로그인, 회원가입
  * 네이버, 카카오 OAuth를 사용한 로그인 및 회원가입
  * 사장님, 소비자 로그인 구분
* 가게 정보 조회
  * 지도의 마커 클릭시 요약 정보 확인 가능
  * 요약 정보 클릭시 상세 정보로 이동
  * 가게 리뷰 확인
* 가게 영업 관리
  * 사장님 유저가 등록한 가게에 대해 영업 시작, 영업 종료를 통해 영업 상태 관리 가능
  * 영업 시작전 영업 위치 수정 가능

### 3-3) 관련 문서
- 와이어프레임
  [EatGo 피그마](https://www.figma.com/file/a6cFVUaw3ZbNe8NuT67fr8/EatGo?type=design&node-id=4-2&mode=design&t=57DrC0J2zENJNhtd-0)

<h2 id="4-사용된-데이터셋과-기술스택">4. 사용된 데이터셋과 기술스택</h2>

### 4-1) ERD
![erd](https://github.com/user-attachments/assets/6d06a76a-8c4b-44b7-87d3-261c0d5942db)

### 4-2) 기술 스택

| 파트                         | 기술                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| ---------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Team** :metal:             | ![image](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white) ![image](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white) ![image](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white) ![image](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)                                                                                                                                                                                                                                                                                                                                                         |
| **Android** :ok_hand:             | ![image](https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white) ![image](https://img.shields.io/badge/android-3DDC84?style=for-the-badge&logo=android&logoColor=white) ![image](https://img.shields.io/badge/firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=white) |
| **BE** :raised_back_of_hand: | ![image](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white) ![image](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![image](https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)|
| **DB** :raised_back_of_hand: | ![image](https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)|

<h2 id="5-시스템-아키텍쳐">5. 시스템 아키텍쳐</h2>

### 5-1) 개발 구조
![image](https://github.com/user-attachments/assets/ab473883-cf72-4f76-aa6c-d8793007a020)

<h2 id="6-프로젝트-팀원-소개">6. 프로젝트 팀원 소개</h2>

| 이름   | 개발 도메인      | 개발 기능 |
| ------ | ---------------- | --------- |
| 양석진 | AI 트레이닝 <br> 회원 <br> 트레이닝 클래스 | - 모션캡쳐 AI 모델 연동 (Teachable Machine) <br> - AI 트레이닝 모델 학습 <br> - AI 트레이닝 진행 로직 <br> - AI 트레이닝 페이지 <br> - 월간 경험치 조회 API <br> - 내 예약 API <br> - 마이페이지 API <br> - 트레이너 리스트 조회, 필터링 |
| 김진우 | 시스템설계 <br> 회원 <br> AI 트레이닝 <br> 백오피스 | - DB 설계 <br> - 마이페이지, 성향파악 페이지 <br> - 내 예약 페이지 <br> - 포인트/경험치 조회 페이지 <br> - 트레이닝 프로그램 리스트, 상세 <br> - 트레이닝, 트레이닝 프로그램 <br> - 피드백 작성 보조 AI (Chat GPT, FastAPI) |
| 이지호 | 트레이닝 클래스 <br> 회원 <br> 백오피스 | - Web RTC 화상트레이닝 (OpenVidu) <br> - 로그인 <br> - 인증 및 보안 (Spring Security, JWT) <br> - 포인트/경험치 생성 API <br> - 트레이닝 히스토리 API <br> - 월간 트레이닝 피드백 <br> - 트레이닝 클래스 예약 관리 <br> - 트레이닝 피드백 작성 |
| 최승렬 | 인프라 <br> 메인 <br> 트레이닝 클래스 <br> AI 트레이닝 | - 인프라 아키텍쳐 (AWS, On-Premis) <br> - CI/CD (Jenkins) <br> - 정적 콘텐츠 서버 (FastAPI) <br> - 메인 <br> - 트레이닝 프로그램 추천 알고리즘 <br> - 트레이너 상세, 클래스 예약 <br> - AI 트레이닝 리포트 <br> - 모션 판정 로직 |

