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

$sql = "create table gyy
(FirstName varchar(15),
LastName varchar(15),
Age int
)";
mysql_query($sql,$con);

mysql_close($con);

?>