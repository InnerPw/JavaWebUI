package ru.geekbrains.webui.lesson4;

public class Triangle {

    public long someMethod(int a, int b, int c) throws MyException {
        if(a<0 || b<0) throw new MyException("Текст моей ошибки");
        int p = (a+b+c)/2;
        double square = Math.sqrt((p*(p-a)*(p-b)*(p-c)));
        long result = Math.round(square);
        return result;
    }

}
