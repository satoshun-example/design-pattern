from abc import ABCMeta, abstractmethod


class Component(object):
    __metaclass__ = ABCMeta

    @abstractmethod
    def print_all(self): pass

    def get_component_list(self):
        return []


class Directory(Component):
    def __init__(self, name, *components):
        self.__name = name
        self.__components = components

    def print_all(self):
        print(self.__name)

        for component in self.__components:
            component.print_all()

    def get_component_list(self):
        result = []
        for component in self.__components:
            result.append(component.get_component_list())
        return result


class File(Component):
    def __init__(self, name):
        self.__name = name

    def print_all(self):
        print('    file name: {0}'.format(self.__name))

    def get_component_list(self):
        return [self.__name]


if __name__ == '__main__':
    root = Directory('root',
        File('hogehoge.png'), File('ugauga.txt'),
        Directory('child', File('guwaguwa.jpg')))
    root.print_all()

    print(root.get_component_list())
