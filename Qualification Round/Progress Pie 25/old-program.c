#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    FILE * fp;
    char * line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen("progress_pie_example_input.txt", "r");
    if (fp == NULL)
        exit(EXIT_FAILURE);
    int T = getline(&line, &len, fp);
        //printf("Retrieved line of length %zu :\n", read);
        printf("%s", line);
while(T<0){
    getline(&line, &len, fp);
    printf("%s", line);
    T--;
}

    

    fclose(fp);
    if (line)
        free(line);
    exit(EXIT_SUCCESS);
}