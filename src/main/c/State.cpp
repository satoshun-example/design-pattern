#include <stdio.h>


class Greeting
{
public:
    virtual void compute() = 0;
};


class Morning : public Greeting
{
public:
    virtual void compute()
    {
        printf("%s\n", "Good Morning");
    }
};


class Evening : public Greeting
{
public:
    virtual void compute()
    {
        printf("%s\n", "Good Evening");
    }
};


class Night : public Greeting
{
public:
    virtual void compute()
    {
        printf("%s\n", "Good Night");
    }
};

int
main(void)
{
    Morning morning;
    Evening evening;
    Night night;

    Greeting* greeting = &morning;
    greeting->compute();

    greeting = &evening;
    greeting->compute();

    greeting = &night;
    greeting->compute();

    return 0;
}
