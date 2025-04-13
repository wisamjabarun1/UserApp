
CREATE TABLE TheUser (
    Id INT AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    Last_Name VARCHAR(20) NOT NULL,
    Email VARCHAR(50),
    Age INT NOT NULL,
    Address VARCHAR(60) NOT NULL,
    Joining_date DATE NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE UserAndQuestionAndAnswer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    selected_option VARCHAR(100) NOT NULL
);


















