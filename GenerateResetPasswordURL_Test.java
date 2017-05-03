package com.everbridge.scripts.manager_portal.org_level.contacts.contact;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.MyHelper;
import com.everbridge.annotations.TestCaseIds;
import com.everbridge.mongodb.ebsuite.beans.MemberPortalUserBean;
import com.everbridge.portal.actions.common.DialogAction;
import com.everbridge.portal.actions.common.GridTableAction;
import com.everbridge.portal.actions.org_level.contacts.ContactAction;
import com.everbridge.portal.enums.TableEnum;
import com.everbridge.testng.assertion.AssertBase;
import enums.GroupEnum;
public class GenerateResetPasswordURL_Test {
    
    String memberUserFn = "";
    
    @BeforeClass
    public void bc() {
        MemberPortalUserBean member = new MemberPortalUserBean().read(MyHelper.suiteName);
        memberUserFn = member.getFirstName();
    }
    
    @Test(groups={GroupEnum.CoreFunctionRegression, GroupEnum.Bai_Jingjiao})
    @TestCaseIds({"MN-3537"})
    public void verify() {
        ContactAction contact = new ContactAction(true);
        contact.firstNameInput.input(memberUserFn);
        contact.searchBtn.click();
        GridTableAction.tableCell(memberUserFn, TableEnum.EditIcon).click();
        
        AssertBase.assertTrue(contact.generateAResetPasswordURLBtn.isDisplayed());
        contact.generateAResetPasswordURLBtn.click();
        AssertBase.assertTrue(contact.resetPasswordURLDiv.isDisplayed());
        DialogAction.cancelBtn.click();
    }
}
