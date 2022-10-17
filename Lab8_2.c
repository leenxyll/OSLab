// 64050001 กขนิกา แย้มศรวล
//q1 : 20! = 2432902008176640000
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
#include <unistd.h>
int main(void){
    pid_t pid = fork();
    if (pid == 0) {
        printf("child create\n");
        while(1);
        printf("this line should not be shown");
        exit(0); 
    } else {
        sleep(4);
        printf("parent working\n");
        kill(pid,SIGKILL);
    }
    printf("child was killed by parent\n");
}