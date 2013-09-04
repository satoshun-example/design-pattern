#include <stdio.h>


class Weather
{
public:
    virtual void compute() = 0;
};


class Morning : public Weather
{
public:
    virtual void compute()
    {
        printf("%s\n", "Good Morning");
    }
};


class Evening : public Weather
{
public:
    virtual void compute()
    {
        printf("%s\n", "Good Evening");
    }
};


class Night : public Weather
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

    Weather* weather = &morning;
    weather->compute();

    weather = &evening;
    weather->compute();

    weather = &night;
    weather->compute();

    return 0;
}
