



Topological sorting

- Works only for DAG
- can be used to find cycles in graph or to get the order in which traversal can be complted
- can use DFS or BFS using Khans algo

Khans's Algo

- create the graph in the oder prereq -> course
- create indegree of the graph where indegree is number of dependencies the node has
- pick all nodes with no dependency to a queue
- pick elements from queue and mark as completed (count the completed node count)
- and reduce indegree of all nodes that has dependency on this node
- check if completed count = number