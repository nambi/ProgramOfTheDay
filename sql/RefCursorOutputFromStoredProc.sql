/*
* How to DBMS print the ref cursor output from the stored procedure. A Must for debugging stored procedures   
*/

DECLARE
employeeId_in NUMBER :=1242;
TYPE employeeDetailsList IS REF CURSOR;
TYPE employeeDetailsOutputType IS RECORD
  (
    EmpId      NUMBER,
    EmpName          VARCHAR2(100),
    Status           VARCHAR2(100),
 );
 vOut employeeDetailsList;
 ouputRecord employeeDetailsOutputType;

BEGIN
  EmployeePackage.getEmployeeDetails(vOut,employeeId_in);
  LOOP
    FETCH vOut INTO ouputRecord;
  EXIT
WHEN vOut%NOTFOUND;
  dbms_output.put_line(ouputRecord.EmpId||','||ouputRecord.EmpName||','||ouputRecord.Status);
END LOOP;
END

/*
Another way to do it through SQL Plus

SQL> variable vOut refcursor
SQL> exec EmployeePackage.getEmployeeDetails(:vOut,1242);
SQL> print vOut

*/
