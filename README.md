# EsempioMultiThread
Un piccolo esempio sull'uso dei thread in Java

La classe per far partire il programma è chiamata ProgramStart.

Il programma funziona da riga di comando. 
Viene chiesto di inserire un numero intero del quale restituisce:
 - la sommatoria da 1 a N;
 - il successivo numero primo maggiore di N;
 - il numero di divisori di N;

Il programma termina quando viene inserito un numero negativo.
Ignora tutti gli input che non sono numeri interi.

Il programma implementa anche una versione per il calcolo del N-esimo elemento della serie di fibonacci (utilizzando sia l'interfaccia Runnable che l'interfaccia Callable), ma non viene utilizzato perchè genera facilmente overflow.
