<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.io.RandomAccessFile"%>  
<%@page import="java.io.ByteArrayOutputStream"%>  
<%@page import="java.io.FileOutputStream"%>  
<%@page import="java.io.DataInputStream"%>  
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
         pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
   
 String savePath = "F:/PsearchWK/PsearchWeb/WebContent/avatar";   // o diretório onde os arquivos carregados serão salvos  
    
 String filename = "";     
     
 ServletInputStream in = request.getInputStream(); //uma referencia do objeto da solicitaçao http onde tem o conteudo do arquivo carregado  
     
 //o inicio do arquivo carregado  e separado pelo limite e uma sequencia de caracteres  
 //de carros de retorno-alimentador de linha ledo o HttpServeltRequest linha a linha  
 byte[] line = new byte[128];  // define um array de byte chamado line  
 int i = in.readLine(line, 0, 128);  //usar o metodo readLine de ServeltInputStream para ler a 1a linha do conteudo do objeto http  
 int boundaryLength = i - 2; //o comprimeto atual da linha -2 do que o num de bytes retornado do metodo readLine  
 String boundary = new String(line, 0, boundaryLength);   //Descarta os 2 ultimos caracteres da linha  
  
 //tendo recuperado o limite, entao pode iniciar a extraçao do elemento de valor de formulario, lendo o conteudo do objeto  
 // http linha por linha, usando a loop while, ate q ela atinja o final, qdo o medoto readLine retorna -1  
  while (i != -1) {    
    String newLine = new String(line, 0, i);     
    if (newLine.startsWith("Content-Disposition: form-data; name=\"")) {    
      String s = new String(line, 0, i-2);//agora pode conseguir o nome de arquivo a partir da string de leitura  
      int pos = s.indexOf("filename=\"");     
      if (pos != -1) {    
        String filepath = s.substring(pos+10, s.length()-1);     
        // navegadores do Windows incluem o caminho completo do cliente,  
        // mas Unix / Linux e navegadores de Mac só enviar o arquivo de teste  
        // se este é de um navegador para Windows  
        pos = filepath.lastIndexOf("\\");     
        if (pos != -1)     
          filename = filepath.substring(pos + 1);     
        else     
          filename = filepath;     
      }     
    
      //este é o conteúdo do arquivo  
      i = in.readLine(line, 0, 128);  //depois de conseguir o nome de arquivo, notara os dois pares de caracteres  
      i = in.readLine(line, 0, 128); //carro de retorno-alimentador de linha antes do inico do conteudo do arquivo carregado  
      // blank line                  //pois isto chama o metodo readLine duas vezes  
      i = in.readLine(line, 0, 128);     
    
      ByteArrayOutputStream buffer = new  //depois inicia o conteudo atual do arquivo, que e armazenado em um ByteArrayOutputStream  
      ByteArrayOutputStream();  
      newLine = new String(line, 0, i); // que continua lendo a linha ate encontrar um outro limite  
    
      while (i != -1 && !newLine.startsWith(boundary)) {    
       // o problema é a última linha do conteúdo do arquivo contém o caractere nova linha.  
       // Então, nós precisamos verificar se a linha atual é a última linha  
        buffer.write(line, 0, i);     
        i = in.readLine(line, 0, 128);     
        newLine = new String(line, 0, i);     
      }     
      try {    
        // salvar o arquivo carregado               //o limite sinaliza o final do arquivo carregado  
        RandomAccessFile f = new RandomAccessFile(  //sendo sua etapa e salvar o buffer em um arquivo  
          savePath + filename, "rw");     
        byte[] bytes = buffer.toByteArray();     
        f.write(bytes, 0, bytes.length - 2);     
        f.close();     
      }     
      catch (Exception e) {}     
    }     
    i = in.readLine(line, 0, 128);     
    
  } // fim do while
%>


</body>
</html>