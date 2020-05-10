<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Khai báo thư viên JSTL -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Latest compiled and minified CSS & JS -->
<link rel="stylesheet" media="screen"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Movie Form</title>
</head>
<body>
	<div class="container">
		 <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <form action="/movies-crud/ActionManagementServlet" method="POST" role="form">
                <legend>${movie == null ? 'Add new movie' : 'Update movie'}</legend>
            
                <div class="form-group">
                    <label for="">ID:</label>
                    <input type="text" class="form-control" name="id" value="${movie.id}" placeholder="Movie ID">
                </div>
                <div class="form-group">
                    <label for="">Title:</label>
                    <input type="text" class="form-control" name="title" value="${movie.title}" placeholder="Title of Movie">
                </div>
                <div class="form-group">
                    <label for="">Year:</label>
                    <input type="text" class="form-control" name = "year" value="${movie.year}" placeholder="Publishing Year">
                </div>
                <div class="form-group">
                    <label for="">Directors:</label>
                    <textarea name="directors" class="form-control" rows="5"  placeholder="Directors" wrap="hard">            
                    	<c:forEach var="direc" items="${movie.directors}">
                    		${direc}
                    	</c:forEach>                
                    </textarea>
                </div>
                <div class="form-group">
                    <label for="">Actors:</label>
                    <textarea name="actors" class="form-control" rows="5" required="required" placeholder="Actors">
                    	<c:forEach var="ac" items="${movie.actors}" varStatus="status">
                    		${ac}
                    	</c:forEach>
                    </textarea>
                </div>
                <div class="form-group">
                    <label for="">Duration:</label>
                    <input type="text" class="form-control" name="duration"  value="${movie.running_time_secs}" placeholder="Duration">
                </div>
            
        
                <button type="submit" class="btn btn-success">Submit</button>
                <button type="submit" class="btn btn-danger">Cancel</button>
            </form>
       </div>
	</div>
</body>
</html>