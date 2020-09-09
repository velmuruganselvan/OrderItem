CREATE TABLE IF NOT EXISTS orderitem (
  productid INT  PRIMARY KEY AUTO_INCREMENT,
  productcode VARCHAR  (100) NOT NULL  ,
  productname VARCHAR  (250) NOT NULL  ,
  quantity int not null
);