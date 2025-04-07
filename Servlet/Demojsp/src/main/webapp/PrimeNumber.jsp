<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 
out.print("Prime number ");
 for(int i=2;i<=100;i++){
 for(int j=1;j<=i;j++){
	 if(i%j==0){
		 out.println(i);
		 System.out.println(i);
	 }
 }
}
%>
</body>
</html>