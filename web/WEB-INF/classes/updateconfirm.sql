	select ID into tmpCustomerProductId_ID from t_customer_product where CustomerID = tmpCustId and ProductID=tmpproductid limit 1;
									IF tmpCustomerProductId_ID is null or tmpCustomerProductId_ID =0 THEN
												insert into t_customer_product(CustomerID,ProductID,InvestAmount,CreateTime,Status)values(tmpCustId,tmpproductid,tmpTransAmt,UNIX_TIMESTAMP(),0);
									ELSE
												update t_customer_product set UpdateTime=UNIX_TIMESTAMP(),InvestAmount=InvestAmount+tmpTransAmt where ID=tmpCustomerProductId_ID;
									END IF;