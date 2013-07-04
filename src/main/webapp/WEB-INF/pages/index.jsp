<html>
<head>
    <script scr="js/lib/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">

</head>
<body>
<div class="container">

</div>



<script type="text/template" id="navBarTemplate">

    <div class="navbar span10">
        <div class="navbar-inner">
            <img class="logo" src="/resources/img/icon100X99.png" width='40' height='25' >
            <a class="brand" href="#">Registration Application</a>
            <form action="/test" method="post" class="navbar-form pull-left">
                <input id="inputSearch" name="inputSearch" type="text" class="span4">
                <button type="button" class="btn"><i class='icon-search'></i>Search</button>
            </form>
            <ul class="nav">
                <li><a id="addPatient" href="#">Add Patient</a></li>

            </ul>
        </div>
    </div>

</script>

<script type="text/template" id="PatientsForm">
    <h3>Registration New Patient<h3>
    <form>
        <div class="formAdd">
                <p class="hederInfo">Patient Information<p>
                <p><label>First Name <input class="span8" type="text" name='FirstName'></label> 
                   <label>Last Name  <input  class="span8" type="text" name="LastName"></label></p>
                <p class="labelSSN"><label>SSN:       <input class="span8" type="text" name="SSN"></label></p>
                <p class= "birthData"><label>Date birth:<input class="span6" type="text" name="data"> (dd/mm/year)</label></p>
                <p class= "bloc1">
                    <label class="gender">
                        Gender 
                            <select class='span2' name="Gender">
                                <option value="man">Man</option>
                                <option value="woman">Woman</option>
                            </select>
                    </label>
                    <label class='Marital'>
                         Marital status  
                            <select class="span2" name="Marital">
                                <option value="single">Single</option>
                                <option value="married">Married</option>
                            </select>
                    </label>
                </p>
                <p class="Race"><label>Race <input class="span2" type="text" name="Race" ></label></p>
                <p class="bloc2"><label class="Religion">Religion <input class="span3" type="text" name="Religion"></label>
                   <label class='Language'>Language:<input class="span3" type="text" name="Language"></label></p>
        </div>

        <div class="formAdd">
            <p class="hederInfo">Patient contacts</p>
            <p><label class='Address'>Address <input type="text" name="Address"></label></p>
            <p><label class="City">City <input type="text" name="City"></label>
               <label class="State">State <input type="text" name="state"></label>
             </p>
             <p><label class="Phone">Phone Number: <input type="text" name="Phone"></label>
             <label class="Zip">Zip <input type="text" name="Zip"></label></p>
        </div>
        <div class="formAdd">
            <p class="hederInfo">Employer contacts</p>
            <p class='EmpName'><label>Employer name <input type="text" name="EmplName"></label></p>
            <p class='Address'><label>Address <input type="text" name="EmplAddress"></label></p>
            <p><label class="City">City <input type="text" name="EmplCity"></label>
               <label class="State">State <input type="text" name="Emplstate"></label>
             </p>
             <p><label class="Phone">Phone Number: <input type="text" name="EmplPhone"></label>
             <label class="Zip">Zip <input type="text" name="EmplZip"></label></p>
        </div>


    </div>
        <input class='btn btn-info' type="button" value='Add Patient'>

    </form>






</script>

<script data-main="/resources/js/main.js" src="/resources/js/lib/require.js"></script>


</body>
</html>