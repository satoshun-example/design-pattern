## State pattern
class Weather(object):
    def show_information(self): pass


class Sunny(Weather):
    def show_information(self):
        print('Today is sunny')


class Cloudy(Weather):
    def show_information(self):
        print('Today is cloudy')


class Rainy(Weather):
    def show_information(self):
        print('Today is rainy')


def show_weather(instance):
    instance.show_information()


if __name__ == '__main__':
    show_weather(Sunny())
    show_weather(Cloudy())
    show_weather(Rainy())
