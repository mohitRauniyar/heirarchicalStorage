Here’s a **README** for the project, with a focus on **hierarchical storage** in MongoDB:

---

# 📚 **Hierarchical Data Storage Model Representation in MongoDB for a Resume Ranking Application**

## 📌 **Project Overview**
This project implements a **Resume Ranking System** that utilizes a hierarchical data storage model in **MongoDB** to optimize the candidate selection process. The application enables companies to define job-specific skill criteria categorized into **primary, secondary, and least priority** sets, assigning corresponding points. The system leverages a **tree-based data structure** (AVL tree) to efficiently store and retrieve candidate data, ensuring that the most qualified applicants are prioritized for selection.

---

## 🎯 **Objectives**
- Design an efficient system to rank resumes using a tree-based storage model.
- Implement a hierarchical approach to store candidate data and job-related criteria in MongoDB.
- Enhance data retrieval efficiency by adopting an **AVL tree structure**.
- Minimize access and update time in the database by avoiding traditional JSON-based storage.

---

## 🗂️ **Data Storage Model**

### 📄 **Traditional vs Hierarchical Storage**
In MongoDB, data is typically stored in JSON-like **documents** that allow flexible schema designs. However, in a **hierarchical approach**, data is structured as a tree (AVL tree) where:
- **Parent Nodes:** Represent job-related criteria (primary, secondary, and least priority).
- **Child Nodes:** Store the respective skill sets and their associated points.
- **Candidate Nodes:** Store candidate details, which are inserted and sorted based on points.

### 📚 **Why Hierarchical Storage?**
1. **Faster Search and Retrieval:** Using an AVL tree ensures that search, insertion, and deletion operations have a time complexity of **O(log n)** instead of **O(n)** in unbalanced structures.
2. **Sorted Data for Efficient Ranking:** Candidates are ranked by points, allowing efficient retrieval of top candidates.
3. **Reduced Time Complexity:** Hierarchical storage reduces the overhead associated with searching through large JSON documents.

---

## 🌳 **Data Structure Design**

### 1️⃣ **Tree Representation**
- **Root Node:** Contains job-specific criteria and associated skill sets.
- **Internal Nodes:** Store skill information categorized into priority levels.
- **Leaf Nodes:** Store candidate profiles with points and skill match levels.

### 2️⃣ **Insertion and Retrieval**
- When a candidate applies for a job, their skills are matched with the defined criteria, and points are awarded.
- Candidate data is inserted into the AVL tree based on their total score, ensuring that the highest-scoring candidates are retrieved efficiently.

### 3️⃣ **Time Complexity Comparison**
| **Operation**    | **Unbalanced Tree** | **AVL Tree** |
|------------------|---------------------|--------------|
| Best Case        | O(1)                | O(1)         |
| Worst Case       | O(n)                | O(log n)     |

---

## 🗃️ **MongoDB Schema Design**

### 📌 **Collections and Documents**
1. **Jobs Collection**
```json
{
  "_id": ObjectId("job_id"),
  "job_title": "Software Developer",
  "company_name": "ABC Corp",
  "skills": [
    {
      "skill_name": "Java",
      "priority": "Primary",
      "points": 10
    },
    {
      "skill_name": "MongoDB",
      "priority": "Secondary",
      "points": 5
    }
  ]
}
```

2. **Candidates Collection**
```json
{
  "_id": ObjectId("candidate_id"),
  "name": "John Doe",
  "skills": ["Java", "MongoDB"],
  "total_points": 15,
  "applied_job_id": ObjectId("job_id")
}
```

3. **Hierarchy Representation**
```json
{
  "root": {
    "primary": [
      {"skill": "Java", "points": 10},
      {"skill": "Python", "points": 8}
    ],
    "secondary": [
      {"skill": "MongoDB", "points": 5},
      {"skill": "SQL", "points": 4}
    ],
    "least_priority": [
      {"skill": "HTML", "points": 2}
    ]
  }
}
```

---

## 🖥️ **System Workflow**

1. **Job Creation:**
   - Companies create job openings by specifying required skills and priority levels.
   - Data is stored in a hierarchical structure in MongoDB.

2. **Candidate Application:**
   - Candidates apply for jobs by selecting relevant skills.
   - Skills are matched with the predefined job criteria, and points are calculated.
   - Candidate data is inserted into the AVL tree with points as the sorting key.

3. **Resume Ranking:**
   - Candidates with the highest points are placed at the top of the tree.
   - Top candidates are retrieved in O(log n) time when companies request results.

---

## 🧪 **Testing and Validation**

### ✅ **Test Scenarios**
- Insert multiple job openings and verify if hierarchical storage is applied correctly.
- Simulate multiple candidate applications and check if candidates are ranked appropriately.
- Validate AVL tree operations (insertion, deletion, and rebalancing).
- Benchmark retrieval times for hierarchical and traditional approaches.

---

## 📊 **Results and Performance Analysis**

- **Efficiency Gain:** Reduction in retrieval time due to hierarchical data storage.
- **Scalability:** AVL tree-based storage ensures that the system scales with large datasets.
- **Accuracy:** Ensures that top candidates are ranked correctly, aligning with the job-specific criteria.

---

## 🚀 **Future Enhancements**
1. **API Integration:** Connect with LinkedIn and GitHub APIs for additional candidate insights.
2. **Enhanced Security:** Implement two-factor authentication and secure API endpoints.
3. **Exploring Alternative Data Structures:** Consider B-trees or other tree variants for enhanced storage efficiency.
4. **Feedback System:** Collect user feedback for improving platform functionality.

---

## 📢 **Conclusion**
The **Hierarchical Data Storage Model** implemented in MongoDB with AVL tree integration optimizes the resume ranking process by minimizing search and retrieval time. By prioritizing data organization and retrieval efficiency, this system ensures streamlined hiring processes for companies while enhancing candidate evaluation.

---

## 📝 **References**
- MongoDB Documentation
- Research on Tree Structures in Databases
- Comparative Studies on Self-balancing Trees and Search Algorithms

---