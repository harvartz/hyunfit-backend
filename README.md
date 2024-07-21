# 사내 헬스 케어 복지 서비스, Hyunfit

<!-- 목차 -->
<details>
  <summary>목차</summary>
  <ol>
    <li>
        <a href="#1-프로젝트-소개">프로젝트 소개</a>
        <ul>
            <li>1) 프로젝트 주제</li>
            <li>2) 서비스 개요 및 배경</li>
            <li>3) 서비스 목표</li>
        </ul>
    </li>
    <li>
        <a href="#2-서비스-기능-소개">서비스 기능 소개</a>
        <ul>
            <li>1) 메인 기능</li>
            <li>2) 서브 기능</li>
            <li>3) 관련 문서</li>
        </ul>
    </li>
    <li>
        <a href="#3-사용된-데이터셋과-기술스택">사용된 데이터셋과 기술스택</a>
        <ul>
            <li>1) 어떤 데이터셋을 어떻게 전처리하고 사용할것인지</li>
            <li>2) 어떤 방법, 라이브러리나 알고리즘을 사용할것인지</li>
        </ul>
    </li>
    <li>
        <a href="#4-시스템-아키텍쳐">시스템 아키텍쳐</a>
        <ul>
            <li>1) 개발 구조</li>
        </ul>
    </li>
    <li><a href="#5-프로젝트-팀원-소개">프로젝트 팀원 소개</a></li>
  </ol>
</details>

<h2 id="1-프로젝트-소개">1. 프로젝트 소개</h2>

---
### 1-1) 프로젝트 주제
‘Hyunfit’은 건강의 중요성을 인식하고 있지만 건강 관리를 하지 못하고 있는 임직원들을 위해, 회사에서 건강한 사내 운동 문화를 만들어 임직원들의 건강 관리에 도움을 주는 사내 헬스케어 웹 서비스이다. 

### 1-2) 서비스 개요 및 배경
다수의 직장인들은 운동을 하고 싶지만 어떻게 시작해야 할지 모르고 시간적 여유가 부족한 경우가 많다. 이에 ‘Hyunfit’은 집에서도 편리하게 운동을 시작할 수 있도록 홈 트레이닝 환경을 제공하여 시간적 여유가 없는 직장인들에게 도움을 준다. AI 모션 인식 기술을 활용하여 사용자의 운동 자세를 교정하고, 화상 채팅 클래스와 전문가의 지도를 통해 더 나은 운동 경험을 제공한다. 또한 운동 기록을 분석한 리포트를 제공하여 사용자의 운동 성과에 대해서 가시적으로 확인할 수 있으며, 시간을 효과적으로 활용할 수 있게 지원한다.

### 1-3) 서비스 목표
‘Hyunfit’을 통해서 사내에서 임직원들이 건강한 라이프 스타일을 추구할 수 있도록 환경을 제공할 수 있게 도와주는 웹 서비스이다

* 주 사용자 : 사내 임직원, 사내 관리자, 헬스 트레이너

<h2 id="2-서비스-기능-소개">2. 서비스 기능 소개</h2>

---

### 2-1) 메인 기능
* AI 트레이닝
  * '테스트 - 워밍업 - 가이드 - 본 운동 - 종료' 5단계로 트레이닝 구성
  * 테스트: 자세를 제대로 인식할 수 있게 조정하는 단계
  * 워밍업: 본 운동이 들어가기 전에 스스로 카메라를 보며 몸을 풀 수 있는 단계
  * 가이드: 이번 운동의 자세가 미리 나오면서 사용자들이 자세를 익힐 수 있게 도움을 주는 단계
  * 본 운동: 운동을 실제로 진행하며, 제대로 된 자세로 진행할 때마다 갯수가 올라간다. 자세가 올바르지 않으며 갯수가 올라가지 않는다.
  * 종료: 모든 운동이 끝나고 나서 메인 화면, 리포트 화면으로 갈 수 있게 해주는 화면이 나온다.
* 트레이너와 화상 클래스
  * 먼저 트레이너가 예약된 클래스에 세션을 열면, 화상 클래스가 시작된다.
  * 세션이 열리면 사용자가 들어가서 트레이너와 같이 화상 클래스를 진행한다.
* GPT를 활용한 트레이너 피드백 작성
  * 지금까지 회원의 특징, 자세와 같은 특징들을 템플릿화하여 GPT에게 초안을 작성하게 만든다.
  * 트레이너가 많은 사용자들의 피드백 관리를 보다 용이하게 관리할 수록 돕는다.

### 2-2) 서브 기능
* 사용자 설문 조사
  * 사용자의 운동 성향을 미리 파악할 수 있다.
  * 해당 설문 조사 결과를 토대로 메인 화면에 적합한 운동 클래스를 추천해준다.
* 트레이닝 프로그램 등록 및 진행
  * 트레이닝 클래스를 이름을 통해 검색할 수 있으며 클릭 시, 상세 정보를 확인할 수 있다.
  * 트레이너가 본인 회원을 위해 클래스를 직접 만들어서 등록할 수 있다.
* 트레이닝 클래스 사용
  * 트레이너를 검색하고 확인할 수 있다.
  * 클래스 종류, 트레이너 성별, 추천 순, 평점 순, 리뷰 많은 순으로 필터링할 수 있다.
  * 클래스를 시간별로 예약할 수 있다.
  * 화상 클래스 종료 후, 수업에 대한 리뷰를 남길 수 있다.
* 리포트 페이지
  * AI 트레이닝을 통해 진행한 운동에 대해서 리포트를 확인할 수 있다.
  * 칼로리, 출석, 소모시간 등을 확인할 수 있다.
  * 어떤 부위를 집중적으로 진행했는지 그래프를 통해 가시적으로 확인할 수 있다.
 


### 2-3) 관련 문서
- 와이어프레임
  [Hyunfit 피그마](https://www.figma.com/file/b4NubgulfrQrZIOLGjORIF/main?type=design&mode=design&t=caeUlW5rehL6syGF-0)

<h2 id="3-사용된-데이터셋과-기술스택">3. 사용된 데이터셋과 기술스택</h2>

### 3-1) ERD
![erd](https://github.com/user-attachments/assets/6d06a76a-8c4b-44b7-87d3-261c0d5942db)

### 3-2) 기술 스택

| 파트                         | 기술                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| ---------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Team** :metal:             | ![image](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white) ![image](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white) ![image](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white) ![image](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white) ![image](https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&logoColor=white)                                                                                                                                                                                                                                                                                                                                                         |
| **FE** :ok_hand:             | ![image](https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white) ![image](https://img.shields.io/badge/Vuetify-1867C0?style=for-the-badge&logo=vuetify&logoColor=white) ![image](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white) ![image](https://img.shields.io/badge/TailwindCSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white) |
| **BE** :raised_back_of_hand: | ![image](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) ![image](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) |
| **DB** :raised_back_of_hand: | ![image](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)|
| **DIST** :raised_back_of_hand: | ![image](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) ![image](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white) ![image](https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white) |



<h2 id="4-시스템-아키텍쳐">4. 시스템 아키텍쳐</h2>

### 4-1) 개발 구조
![image](https://github.com/user-attachments/assets/ab473883-cf72-4f76-aa6c-d8793007a020)

<h2 id="5-프로젝트-팀원-소개">5. 프로젝트 팀원 소개</h2>

| 이름   | 개발 도메인      | 개발 기능 |
| ------ | ---------------- | --------- |
| 양석진 | AI 트레이닝 <br> 회원 <br> 트레이닝 클래스 | - 모션캡쳐 AI 모델 연동 (Teachable Machine) <br> - AI 트레이닝 모델 학습 <br> - AI 트레이닝 진행 로직 <br> - AI 트레이닝 페이지 <br> - 월간 경험치 조회 API <br> - 내 예약 API <br> - 마이페이지 API <br> - 트레이너 리스트 조회, 필터링 |
| 김진우 | 시스템설계 <br> 회원 <br> AI 트레이닝 <br> 백오피스 | - DB 설계 <br> - 마이페이지, 성향파악 페이지 <br> - 내 예약 페이지 <br> - 포인트/경험치 조회 페이지 <br> - 트레이닝 프로그램 리스트, 상세 <br> - 트레이닝, 트레이닝 프로그램 <br> - 피드백 작성 보조 AI (Chat GPT, FastAPI) |
| 이지호 | 트레이닝 클래스 <br> 회원 <br> 백오피스 | - Web RTC 화상트레이닝 (OpenVidu) <br> - 로그인 <br> - 인증 및 보안 (Spring Security, JWT) <br> - 포인트/경험치 생성 API <br> - 트레이닝 히스토리 API <br> - 월간 트레이닝 피드백 <br> - 트레이닝 클래스 예약 관리 <br> - 트레이닝 피드백 작성 |
| 최승렬 | 인프라 <br> 메인 <br> 트레이닝 클래스 <br> AI 트레이닝 | - 인프라 아키텍쳐 (AWS, On-Premis) <br> - CI/CD (Jenkins) <br> - 정적 콘텐츠 서버 (FastAPI) <br> - 메인 <br> - 트레이닝 프로그램 추천 알고리즘 <br> - 트레이너 상세, 클래스 예약 <br> - AI 트레이닝 리포트 <br> - 모션 판정 로직 |
