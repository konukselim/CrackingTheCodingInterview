class Project:
    def __init__(self, name):
        self.name = name
        self.num_dependencies = 0
        self.dependent_projects = []

class Graph:
    def __init__(self):
        self.projects = []
        self.named_projects = {}
        self.num_projects = 0

    def add_project(self, project):
        pro = Project(project)
        self.projects.append(pro)
        self.num_projects += 1
        self.named_projects[project] = pro

    def add_projects(self, projects):
        for project in projects:
            self.add_project(project)

    def add_edge(self, p1, p2):
        project1 = self.named_projects[p1]
        project2 = self.named_projects[p2]
        project2.dependent_projects.append(project1)
        project1.num_dependencies += 1

    def add_edges(self, dependencies):
        for dependency in dependencies:
            self.add_edge(dependency[0], dependency[1])

def get_build_order(graph):
    order = []
    non_dependent = check_dependencies(graph)
    while(non_dependent):
        order = [non_dependent.name] + order
        graph.projects.remove(non_dependent)
        non_dependent = check_dependencies(graph)

    if len(order) == graph.num_projects:
        return order
    return None

def check_dependencies(graph):
    for project in graph.projects:
        if project.num_dependencies == 0:
            for dependent in project.dependent_projects:
                dependent.num_dependencies -= 1
            return project
    return None

def build_order(projects, dependencies):
    graph = Graph()
    graph.add_projects(projects)
    graph.add_edges(dependencies)
    return get_build_order(graph)