<?php 

function Connection(){
	
/*	
	$ini = parse_ini_file("qms.ini", true);
	$sqlsvr=$ini["sqlserver"]["ServerName"];
	
	//$serverName = "127.0.0.1";
	$serverName=$ini["sqlserver"]["ServerName"];
	$db=$ini["sqlserver"]["Database"];
	$dbuser=$ini["sqlserver"]["UID"];
	$psw=$ini["sqlserver"]["PWD"];
*/	
	$serverName="VANDAO7\SQL2012EN";
	$dbuser="sa";
	$psw="sql2012";
	$db="furniture";
	
	//$connectionInfo = array( "Database"=>"QMS-W18", "UID"=>"sa", "PWD"=>"sql2008","CharacterSet" => "UTF-8");
	$connectionInfo = array( "Database"=>"$db", "UID"=>"$dbuser", "PWD"=>"$psw","CharacterSet" => "UTF-8");

	$conn = sqlsrv_connect( $serverName, $connectionInfo);
	
	if( !$conn ) {
		 die( print_r( sqlsrv_errors(), true));
	}   	

	return $conn;
}

function CloseConnection($conn){
	mssql_close($conn);
}

$conn = Connection();
$params = array();
$options =  array( "Scrollable" => SQLSRV_CURSOR_KEYSET );

/*mysql
 $host      = "localhost";
 $username  = "root";
 $passwrod  = "mysql2008";
 $dbName    = "furniture-shop";

  $con = mysqli_connect($host,$username,$passwrod,$dbName);
*/  
   ?>