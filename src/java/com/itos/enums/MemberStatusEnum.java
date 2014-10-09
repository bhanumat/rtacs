package com.itos.enums;

public enum MemberStatusEnum {

    C10(10, "ยื่นใบสมัคร"),
    C11(11, "ชำระเงินค่าสมัคร"),
    C12(12, "บันทึกข้อมูลเพิ่มเติม"),
    C13(13, "อนุมัติเห็นชอบ"),
    C20(20, "กำหนดเลขทะเบียนสมาชิก"),
    C25(25, "ดำเนินการขออนุมัติขึ้นทะเบียน"),
    C105(105, "อนุมัติขึ้นทะเบียนเป็นสมาชิก"),
    C100(100, "สมาชิกปกติ"),
    C101(101, "ค้างชำระ 1 เดือน"),
    C102(102, "ค้างชำระ 2 เดือน"),
    C103(103, "ค้างชำระ 3 เดือน และได้ดำเนินการทวงถาม"),
    C109(109, "ดำเนินการถอนสภาพชั่วคราว"),
    C110(110, "ถูกถอนสภาพชั่วคราว"),
    C115(115, "บันทึำกขอคืนสภาพ"),
    C116(116, "ชำระเงินค้างชำระ"),
    C119(119, "ดำเนินการคืนสภาพ"),
    C120(120, "คืนสภาพเป็นสมาชิกปกติ"),
    C130(130, "คืนสภาพเป็นสมาชิกปกติกรณีพิเศษ"),
    C199(199, "ดำเนินการถอนสภาพถาวร"),
    C200(200, "ถูกถอนสภาพถาวร"),
    C205(205, "บันทึกแจ้งถึงแก่กรรม"),
    C206(206, "บันทึกการจ่ายค่าจัดการศพ"),
    C207(207, "ขออนุมัติจ่ายค่าจัดการศพ"),
    C210(210, "ถึงแก่กรรม"),
    C220(220, "ลาออก"),
    C231(231, "เสียชีวิตก่อนขึ้นทะเบียน"),
    C232(232, "ไม่อนุมัติขอความเห็นชอบ"),
    C234(234, "ไม่อนุมัติขึ้นทะเบียน");

    private int code;
    private String name;

    MemberStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static MemberStatusEnum valueOf(Integer code) {
        if(code == null) {
            return null;
        }
        for (MemberStatusEnum memberStatus : MemberStatusEnum.values()) {
            if(memberStatus.getCode() == code) {
                return memberStatus;
            }
        }
        return null;
    }
}