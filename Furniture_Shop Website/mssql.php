<?php>

include("database.php");

$conn = Connection();
$params = array();
$options =  array( "Scrollable" => SQLSRV_CURSOR_KEYSET );

?>


<?php				  
					$sql = "SELECT  Display.d_Id, Display.d_Number, dbo.VNI2Unicode(Display.d_Name ) as d_Name 
							FROM    dbo.Display 
							WHERE   (Display.d_On = 1 AND (Display.d_Type=0 OR Display.d_Type=6 OR Display.d_Type=11) ) 
							ORDER BY Display.d_Number;";
					
						if (($rs=sqlsrv_query($conn,$query,$params,$options)) == false)
						{
							echo  print_r(sqlsrv_errors(), true);
						}

					$rows=sqlsrv_num_rows($rs);	
					if ($rows>0) {

					
					while($r=sqlsrv_fetch_array($rs)) {
						$ou = $r['d_Name']; 
						$ouno=$r['d_Number'];
					
						echo "<li><a tabindex='-1' OnClick='doTransfer(2,$ouno,1)'>$ouno-$ou</a></li>";
						
						
					}
?>
