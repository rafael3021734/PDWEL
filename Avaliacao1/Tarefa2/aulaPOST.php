<?php
$media = ($_POST['nota1'] + $_POST['nota2']) / 2;
$nome = $_POST['nome'];
$x = $_POST['nota1'];
$y = $_POST['nota2'];
$resultadoMDC = 0;
$resultadoMMC = 0;
/*if ($media >= 7) {
 print("Aluno $nome aprovado com a média $media <br />\n");
 print("Aluno $nome aprovado com a média $y <br />\n");
}
else {
 print("Aluno $nome reprovado com a média $media \n");
 print("Aluno $nome aprovado com a média $x <br />\n");
}*/
echo mmc($_POST['nota1'],$_POST['nota2']);

function mmc($x,$y){
	$resultadoMMC = (($x*$y)/(mdc($x,$y)));
	echo("O resultado do mmc: $resultadoMMC <br />\n");
    return $resultadoMMC;
}

function mdc($x,$y){
	$a = max($x,$y);
	$b = min($x,$y);
	if($a%$b == 0){
		print("O resultado do mdc: $b <br />\n");
		$resultadoMDC = $b;
		return $resultadoMDC;

	}else{		
		$resultadoMDC = mdc($b,($a%$b));
		print("O resultado do mdc: $resultado <br />\n");
		return $resultadoMDC;
	}
}
?>