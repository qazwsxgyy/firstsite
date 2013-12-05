 <?php
$host = getenv("MOPAAS_MYSQL2792_HOST");
$port = getenv("MOPAAS_MYSQL2792_PORT");
$dbname = getenv("MOPAAS_MYSQL2792_NAME");
$username = getenv("MOPAAS_MYSQL2792_USERNAME");
$password = getenv("MOPAAS_MYSQL2792_PASSWORD");

$con = mysql_connect("$host","$username","$password");

if(!$con)
{
die('could not connect: ' . mysql_error());
}

mysql_select_db("$dbname", $con);

$sql_1 = " insert into gyy (FirstName, LastName, Age) values ('$_POST[FirstName]','$_POST[LastName]','$_POST[Age]') ";


if(!mysql_query($sql_1,$con))
{
die('could not connect: ' . mysql_error());
}

echo "1 record added";


$result = mysql_query("SELECT * FROM gyy", $con);

echo "<table border = '1'>

<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Age</th>
</tr>" ;

while($row = mysql_fetch_array($result))
{
echo "<tr>";
echo "<td>" . $row['FirstName'] . "</td>";
echo "<td>" . $row['LastName'] . "</td>";
echo "<td>" . $row['Age'] . "</td>";
echo "</tr>";
}

echo "</table>";
  
mysql_close($con);

?>
