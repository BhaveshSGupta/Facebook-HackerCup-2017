#include <stdio.h>
#include <stdlib.h>


int toString(char a[]) {
  int c, sign, offset, n;
 
  if (a[0] == '-') {  // Handle negative integers
    sign = -1;
  }
 
  if (sign == -1) {  // Set starting position to convert
    offset = 1;
  }
  else {
    offset = 0;
  }
 
  n = 0;
 
  for (c = offset; a[c] != '\0'; c++) {
    n = n * 10 + a[c] - '0';
  }
 
  if (sign == -1) {
    n = -n;
  }
 
  return n;
}

int main(void)
{
    FILE * fp;
    char * line = NULL;
    char * Tm;
    int T=0;
    size_t len = 0;
    ssize_t read;
    fp = fopen("progress_pie_example_input.txt", "r");
    if (fp == NULL)
        exit(EXIT_FAILURE);
    getline(&line, &len, fp);

    //T=toString(line);
        //printf("Retrieved line of length %zu :\n", read);
//        printf("%s", line);
//int num = atoi(s);
T = atoi(line);
         //printf("%d",T);

while(T>0){
    //printf("%d\n",T);
    getline(&line, &len, fp);
    printf("%s",line);
    T--;
}

    

    fclose(fp);
    if (line)
        free(line);
   
    exit(EXIT_SUCCESS);
}

