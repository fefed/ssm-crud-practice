package com.zdy.ssm.bean;

public class Emp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.emp_id
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    private Integer empId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.emp_name
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    private String empName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.gender
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.email
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_emp.d_id
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    private Integer dId;

    public Emp() {
    }

    public Emp(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

    // 自定义
    // 希望查询员工的同时获取部门信息
    private Dept department;

    public Dept getDepartment() {
        return department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.emp_id
     *
     * @return the value of tbl_emp.emp_id
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.emp_id
     *
     * @param empId the value for tbl_emp.emp_id
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.emp_name
     *
     * @return the value of tbl_emp.emp_name
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.emp_name
     *
     * @param empName the value for tbl_emp.emp_name
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.gender
     *
     * @return the value of tbl_emp.gender
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.gender
     *
     * @param gender the value for tbl_emp.gender
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.email
     *
     * @return the value of tbl_emp.email
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.email
     *
     * @param email the value for tbl_emp.email
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_emp.d_id
     *
     * @return the value of tbl_emp.d_id
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_emp.d_id
     *
     * @param dId the value for tbl_emp.d_id
     *
     * @mbggenerated Thu Aug 31 11:31:32 CST 2023
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }
}