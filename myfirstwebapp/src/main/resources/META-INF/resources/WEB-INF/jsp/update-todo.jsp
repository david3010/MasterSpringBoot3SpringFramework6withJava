<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Update todo</title>
</head>
<body>
<div class="container col-md-9 mt-5">
    <h1>
        Update todo!
    </h1>
    <form:form method="POST" name="todoForm" modelAttribute="todo">
        <form:input path="id" type="hidden"/>
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <form:input path="description" class="form-control" type="text" id="description"
                        name="description" required="required"/>
            <form:errors path="description"/>
        </div>
        <div class="mb-3 form-check">
            <label for="done" class="form-check-label">Done:</label>
            <form:checkbox path="done" class="form-check-input" id="done" name="done"/>
            <form:errors path="done"/>
        </div>
        <div class="mb-3">
            <label for="targetDate" class="form-label">TargetDate:</label>
            <form:input path="targetDate" class="form-control" type="date" id="targetDate" name="targetDate"/>
            <form:errors path="targetDate"/>
        </div>
        <div class="d-grid gap-2 col-6 mx-auto">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form:form>
</div>
<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>