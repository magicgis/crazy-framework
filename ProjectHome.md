# Motivation #

프로젝트를 신규로 시작할때 마다 비지니스 요건에 맞게 framework을
재구성해야 했습니다. 기존에 사용했던 기능적 부분을 가져다가
적용을 하려고 하니, 덩어리가 너무 커서 (비즈니스 로직, 외부연동 모듈, 유틸리티 등)
하나하나 적용하기 너무 어려웠습니다. 그리고 새로운 오픈소스를 simple 하게
테스트를 진행하려고 해도 복잡한 환경 설정(이클립스 셋팅, 메이븐 설정, 라이브러리 설정, 스프링 설정)부분이 비중을 더 많이 차지 했습니다.
거기다가 소스들을 분산적으로 관리가 되어서 잘 정리가 되지 않는 문제도
발생 했습니다. 그래서 기능 위주의 검증용 프로젝트를 만들어서
빠르고 쉽고, 관리도 편하기 위해서 시작하게 되었습니다.

# Concept #

본 프로젝트는 기본적으로 POC(Proof Of Concept)가 주목적인 프로젝트 입니다.
그렇기 때문에 내부적으로는 HSQL기반 (In-Memory) 방식을 사용 하며,
검증을 위한 최소한의 비지니스 로직만 구현 합니다.

# Participation #

Framework 관심이 있는 분은 누구나 참여 가능합니다. 단 기술 자격 조건은
svn에서 체크 아웃을 해서 이클립스에서 실제로 실행을 할 수있는
분이면 가능 합니다. 참고로 프로젝트에 참여를 통해서 배우려고만 하는분은
자제를 부탁 드립니다.
참여의사가 있으신 분들은 beyondj2ee@gmail.com 으로
사전에 메일로 보내 주시기 바랍니다.

# POC List #

| poc id| technologies | description | developer |
|:------|:-------------|:------------|:----------|
| mybatis-crud| mybatis3.0+spring3.0 MVC+tomcat7 | mybatis와 spring 연동 과 service,mapper crud 추상화를 통한 생산성 향상 | taeki.kim |
| validation | spring Validation+JSR303| Spring Validation 과 JSR303 을적용한 서버 데이터 검증 | taeki.kim |
| ajax  | jQuery 1.6+JSR303| jQuery Ajax 연동, Validation, Exception 처리 | taeki.kim |
| shiro |Shiro 1.0+Spring 3.0 MVC | Shiro 1.0 + JDBC 연동  |taeki.kim  |

# POC 실행 방법 #

| poc id | how to run | description |
|:-------|:-----------|:------------|
| mybatis-crud| http://localhost:8080/crazyframework/mybatis/getAll.htm | 실행하는 WAS Port에 따라 수정해야함 |
| validation | http://localhost:8080/crazyframework/validation/index.htm | 실행하는 WAS Port에 따라 수정해야함 |
| ajax   | http://localhost:8080/crazyframework/ajax/index.htm | 실행하는 WAS Port에 따라 수정해야함 |
| shiro  | http://localhost:8080/crazyframework/shiro/login.htm | 실행하는 WAS Port에 따라 수정해야함 |
# SVN URL #
※Read Only만 가능 합니다.
http://crazy-framework.googlecode.com/svn/trunk/

DEV DIRECTORY

c:\
> project\_poscoict
> > eclipse
> > servers
> > tools
> > > apache-ant
> > > apache-maven

> > workspace

DEV SETTING

(1) 개발 환경을 설정하기 전에 반드시 JDK 1.6를 설치한다. 설치 경로는 기본값으로 한다. JDK 설치 후 아래와 같이 환경 변수를 추가한다.

(2) 통합 IDE를 다운로드 받는다. Part1 Part2 Part3 Part4

(3) 다운로드 받은 파일을 "C:\" 복사 후 압축 해제 한다. ※ 압축 해제는 "알집"을 이용해서 해제 한다.

(4) 위 의 "DEV DIRECTORY" 구조로 압축이 해제 되어 있는지 확인한다.

(5) 아래와 같이 환경 변수를 설정 한다.
환경 변수 	설정 값
JAVA\_HOME 	jdk 설치 경로
M2\_HOME 	C:\project\_poscoict\tools\apache-maven\2.2.1
ANT\_HOME 	C:\project\_poscoict\tools\apache-ant\1.8.1
PATH 	%JAVA-HOME%\bin;%M2\_HOME%\bin;%ANT\_HOME%\bin;(이전 PATH)

CLASS EXPRESSION

구현 클래스는 "인터페이스명+ "Impl" "로 생성 합니다.

"---" 는 기능명을 말합니다.
Application 	Expression 	Dependency 	Description 	Sample
Controller 	---Controller	Service	요청을 처리할 컨트롤러 	LoginController
Service 	---Service	DAO	비즈니스 로직 모듈 	LoginService
DAO 	---DAO	Persistence API	DAO클래스 	LoginDAO
Filter 	--Filter	None	Servlet Filter 	UserFilter
Interceptor 	--Interceptor	None	Spring Interceptor 	UserInterceptor
Domain 	prefix 와 postfix 없음	None	도메인 클래스 	User

METHOD EXPRESSION

"---" 는 기능명을 말합니다. "eq" 위에 것과 동일하다는 뜻 입니다.

Class 	C 	U 	D 	R(view) 	R(list) 	Exist 	Has 	Add Form 	Edit Form
Controller 	create--- 	modify--- 	remove--- 	view--- 	list--- 	is--- 	has---
Invoke URL 	eq 	eq 	eq 	eq 	eq 	eq 	eq 	addForm-- 	editForm--
Service 	eq 	eq 	eq 	eq 	eq 	eq 	eq
DAO 	insert--- 	update--- 	delete--- 	select--- 	selectList--- 	eq 	eq

META DESCRIPTION

Open Source 	DESCRIPTION 	Path
Spring 	properties, annotation 설정 	src/main/resources/contexts/application.context.xml
Spring 	datasource 설정 	src/main/resources/contexts/datasource.context.xml
Spring 	servlet 설정 	src/main/resources/servlets/applcation.servlet.xml
IBATIS 	config 설정 	src/main/resources/sqlmaps/ibatis.cfg.xml
IBATIS 	dummy map 설정 	src/main/resources/sqlmaps/dummy.xml
IBATIS 	sqlmap 설정 	src/main/resources/sqlmaps/1depth/2depth.sqlmap.xml
DOZER	도메인 맵핑 설정 	src/main/resources/mappings/1depth/2depth.sqlmap.xml
properties 	application properties 설정 	src/main/resources/application.properties
LOG4J	Log4J Properties 	src/main/resources/log4j.properties
MESSAGE	다국어 메세지 	src/main/resources/messages/depth1.properties
JQUERY 	Ajax Library 	src/main/webapp/resources/js/jquery/1.4.2/jquery.js

WEB RESOURCE EXPRESSION

호출 URL,JS,JSP 는 루트 디렉토리를 제외한 나머지 경로는 반드시 동일 해야 합니다. URL 호출 확장명은 ".do" 로 합니다.
Resource 	Root Directory 	Description 	Sample
invoke URL 	"/"	사용자가 웹 브라우져에서 호출 하는 URL 입니다. 	http://..:8080/showcase/chapter1/hello.do
JSP 	"/WEB-INF/views/jsp"	랜더링 하기 위한 뷰입니다. 	WEB-INF/views/jsp/showcase/chapter1/hello.jsp
JS 	"/js"	모든 js파일은 JSP 한개당 하나씩 생성해야 합니다.. 	/js/showcase/chapter1/hello.js

WEB CONTEXT NAME

Web Context 명은 "/poscoict"로 한다. 예) http://localhost:8080/poscoict/hello.do
DEV PHYSICAL DIRECTORY

poscoict

> src
> > main
> > > java
> > > > com
> > > > > poscoict
> > > > > > 신규 프로젝트명
> > > > > > > dao
> > > > > > > > depth1
> > > > > > > > Depth2DAO (interface)
> > > > > > > > > impl
> > > > > > > > > Depth2DAOImpl (class)

> > > > > > > service
> > > > > > > > depth1
> > > > > > > > Depth2Service (interface)
> > > > > > > > > impl
> > > > > > > > > Depth2ServiceImpl (class)

> > > > > > > web
> > > > > > > > controller
> > > > > > > > > depth1
> > > > > > > > > Depth2Controller (class)

> > > > > > > > filter
> > > > > > > > > depth1
> > > > > > > > > Depth2Filter (class)

> > > > > > > > interceptor
> > > > > > > > > depth1
> > > > > > > > > Depth2Interceptor (class)

> src
> > main
> > > resources
> > > > contexts
> > > > application.conext.xml
> > > > servlets
> > > > applcation.servlet.xml
> > > > sqlmaps
> > > > dummy.xml
> > > > ibatis.cfg.xml
> > > > depth1
> > > > > depth2.sqlmap.xml

> > > > mappings
> > > > > depth1
> > > > > depth2.mapping.xml

> > > > application.properties
> > > > log4j.properties
> > > > messages
> > > > > depth1.properties

> src
> > main
> > > webapp
> > > > resources
> > > > > js
> > > > > > query
              1. 4.2
> > > > > > > > jquery.js

> > > > > css
> > > > > image
> > > > > js

> > > > WEB-INF
> > > > > view
> > > > > > jsp
> > > > > > > depth1
> > > > > > > > depth2

> > test
> > > java
> > > resources

> target
> > classes
> > test-classes
build.xml
pom.xml
app.wiki