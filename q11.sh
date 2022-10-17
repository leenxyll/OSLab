for file in $(find . -type f -name "*.c")
do
    trimmedName=`echo $file | cut -d'/' -f2 | cut -d'.' -f1`
    gcc -o $trimmedName $file
    if [ -f $trimmedName ]
    then
        ans=$(./trimmedName)
        if [ $ans=20 ]
        then
                point=10
        else
                point=7
        fi
    else
        point=5
    fi
    printf "%s\t%s\n" $file $point
done
