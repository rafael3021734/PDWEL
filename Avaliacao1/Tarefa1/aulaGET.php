<?php

$x = $_GET['m'];
$y = $_GET['n'];
$resultadoMDC = 0;
$resultadoMMC = 0;


echo mmc($_GET['m'],$_GET['n']);

function mmc($x,$y){
	$resultadoMMC = (($x*$y)/(mdc($x,$y)));
	print("O resultado do mmc: $resultadoMMC <br />\n");
    
}

function mdc($x,$y){
	$a = max($x,$y);
	$b = min($x,$y);
	if($a%$b == 0){
		print("O resultados do mdc: $b <br />\n");
		$resultadoMDC = $b;		
		return $resultadoMDC;

	}else{		
		$resultadoMDC = mdc($b,($a%$b));
		print("O resultado do mdc: $resultadoMDC <br />\n");
		return $resultadoMDC;
	}
}
?>