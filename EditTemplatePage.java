package com.everbridge.portal.pages.org_level.incidents;
import java.util.EnumMap;
import org.openqa.selenium.JavascriptExecutor;
import com.everbridge.portal.actions.org_level.incidents.EditTemplateActions.BodyEnum;
import com.everbridge.portal.enums.ContactsTypeEnum;
import com.everbridge.portal.enums.DeliveryMethodEnum;
import com.everbridge.portal.enums.PhoneNumberEnum;
import com.everbridge.portal.enums.incidents.EBVariablesIdEnum;
import com.everbridge.portal.pages.common.CommonPage;
import com.everbridge.qa.selenium_lib.util.ByUtil;
import com.everbridge.qa.testng_listener.Helper;
public class EditTemplatePage {
    
    public EditTemplatePage(boolean... ifOpen){
        if (ifOpen != null&&ifOpen.length!=0&&ifOpen[0]==true) {
            new IncidentTemplatesPage(true).newIncidentTemplateBtn.click();
        }
    }
    
    private String xpathForElementVisible = CommonPage.xpathForElementVisible;
    
    public ByUtil returnToTemplateListLink = ByUtil.xpath("//a[@href='/incidents/incident#templates']");
    
    public ByUtil nameInput = ByUtil.id("incidentTemplateName");
    
    public ByUtil draftRadio = ByUtil.id("incidentStatus1");
    
    public ByUtil liveRadio = ByUtil.id("incidentStatus2");
    
    public ByUtil saveBtn = ByUtil.id("formSave");
    
    public ByUtil saveAndCopyBtn = ByUtil.id("fromSaveCopy");
    
    public ByUtil cancelBtn = ByUtil.id("cancel");
    
    public ByUtil categoryInput = ByUtil.xpath("//*[@id='selIncidentCategory']/following-sibling::span//input");
    
    public ByUtil categoryDropdownIcon = ByUtil.xpath("//*[@id='selIncidentCategory']/following-sibling::span/a");
    
    public ByUtil categoryDropdownItem(String existCategory){
        return ByUtil.xpath("//ul[contains(@id,'ui-id')]//a[normalize-space(text())='"+ existCategory + "']");
    }
    
    public ByUtil phase1Tab = ByUtil.xpath("(//a[contains(@class,'templateTab')])[1]");
    public ByUtil phase2Tab = ByUtil.xpath("(//a[contains(@class,'templateTab')])[2]");
    public ByUtil phase3Tab = ByUtil.xpath("(//a[contains(@class,'templateTab')])[3]");
    
    public ByUtil manageLink = ByUtil.id("manageVersion");
    
    public ByUtil manageDialogPhaseNameTd(int index) {
        String xpath = "(//tbody[starts-with(@id,'notificationPhasesTbody')]//tr)["+ index + "]//td[@class='phasename']";
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil manageDialogPhaseNameInput = ByUtil.xpath("//div[@role='dialog']//td[@class='phasename']//input");
    
    public ByUtil manageDialogNewRadio(int index) {
        String xpath = "(//div[@role='dialog']//input[@value='new'])["+ index + "]";
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil manageDialogUpdateRadio(int index) {
        String xpath = "(//div[@role='dialog']//input[@value='update'])["+ index + "]";
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil manageDialogCloseRadio(int index) {
        String xpath = "(//div[@role='dialog']//input[@value='close'])["+ index + "]";
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil manageDialogCopyBtn(int index) {
        String xpath = "(//div[@role='dialog']//input[@type='button'])["+ index + "]";
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil manageDialogPhase2Cb = ByUtil.xpath("(//div[@role='dialog']//input[@type='checkbox']" + xpathForElementVisible + ")[1]");
    public ByUtil manageDialogPhase3Cb = ByUtil.xpath("(//div[@role='dialog']//input[@type='checkbox']" + xpathForElementVisible + ")[2]");
    public ByUtil manageDialogDeleteBtn = ByUtil.xpath("//div[@role='dialog']//button[starts-with(@id,'deleteTemplate')]");
    
    public ByUtil formAndMessageLink = ByUtil.xpath("//li[@appcontainer='formNotificationContainer']" + xpathForElementVisible);
    public ByUtil contactsLink = ByUtil.xpath("//li[@appcontainer='contactsContainer']" + xpathForElementVisible);
    public ByUtil settingsLink = ByUtil.xpath("//li[@appcontainer='settingContainer']" + xpathForElementVisible);
    public ByUtil permissionsLink = ByUtil.xpath("//li[@appcontainer='permissionContainer']" + xpathForElementVisible);
    
    public ByUtil errorIcon_formAndMessageTab = ByUtil.xpath("//label[starts-with(@id,'formMessageValidLabel')]" + xpathForElementVisible);
    public ByUtil errorIcon_contactsTab = ByUtil.xpath("//label[starts-with(@id,'contactsValidLabel')]" + xpathForElementVisible);
    public ByUtil errorIcon_settingsTab = ByUtil.xpath("//label[starts-with(@id,'settingValidLabel')]" + xpathForElementVisible);
    
    public ByUtil operatorsFormTab = ByUtil.xpath("//li[@name='operatorForm']" + xpathForElementVisible);
    public ByUtil outgoingMessageTab = ByUtil.xpath("//li[@name='outgoing']" + xpathForElementVisible);
    
    public ByUtil highPriorityMessageCb = ByUtil.xpath("//input[@name='priority']" + xpathForElementVisible);
    public ByUtil titleInput = ByUtil.xpath("//*[starts-with(@id,'messageTitle')]" + xpathForElementVisible);
    
    public ByUtil hideListOfVariablesCb = ByUtil.xpath("//input[starts-with(@id,'hideVariablesvie')]" + xpathForElementVisible);
    public ByUtil bodyPreMsgTextarea = ByUtil.xpath("//*[starts-with(@id,'preMessage')]" + xpathForElementVisible);
    public ByUtil bodyPostMsgTextarea = ByUtil.xpath("//*[starts-with(@id,'postMessage')]" + xpathForElementVisible);
    public ByUtil bodyFormarea = ByUtil.xpath("//div[starts-with(@id,'variableValueListContainer')]" + xpathForElementVisible);
    public ByUtil tipTextSpan = ByUtil.xpath("//span[starts-with(@id,'tipTextMessage')]" + xpathForElementVisible);
    
    /**
     * <pre>Example:
     * tokenSpan(BodyEnum.Title, "{Notification Status}")
     * tokenSpen(BodyEnum.Title, "{Today's Date}") -->can't work, because the "'" has special meaning for xpath.
     * </pre>
     * @param be
     * @param token
     * @return
     */
    public ByUtil tokenSpan(BodyEnum be, String token) {
        String xpath = "";
        switch(be) {
        case Title:
            xpath = "//div[starts-with(@id,'messageTitle')]//span[text()='" + token + "']";
            break;
        case BodyPreMsg:
            xpath = "//div[starts-with(@id,'preMessage')]//span[text()='" + token + "']";
            break;
        case BodyPostMsg:
            xpath = "//div[starts-with(@id,'postMessage')]//span[text()='" + token + "']";
            break;
        }
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil includeAVoiceRecordingCb = ByUtil.xpath("//input[starts-with(@id,'includeAVoice')]" + xpathForElementVisible);
    public ByUtil useEverbridgeRecorderRadio = ByUtil.xpath("//input[@value='WebRecorder']" + xpathForElementVisible);
    public ByUtil useATelephoneRadio = ByUtil.xpath("//input[@value='LandlineRecorder']" + xpathForElementVisible);
    public ByUtil useUploadAFileRadio = ByUtil.xpath("//input[@value='WebUploader']" + xpathForElementVisible);
    
    public ByUtil uploadAFileLink = ByUtil.xpath("//object[@id='SWFUpload_0']" + xpathForElementVisible);
    
    public ByUtil standardRadio = ByUtil.xpath("//input[starts-with(@id,'notificationType0')]" + xpathForElementVisible);
    
    public ByUtil pollingRadio = ByUtil.xpath("//input[starts-with(@id,'notificationType1')]" + xpathForElementVisible);
    public ByUtil useQuotaCb = ByUtil.xpath("//input[starts-with(@id,'quotaCheckbox')]" + xpathForElementVisible);
    public ByUtil addAnotherLink_pollingAnswer = ByUtil.xpath("//a[starts-with(@id,'add_polling_answer')]" + xpathForElementVisible);
    
    public ByUtil textResponseInput(int index) {
        String xpath = "(//input[contains(@class,'polling_answer')])[" + index + "]" + xpathForElementVisible;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil neededInput(int index) {
        String xpath = "(//input[contains(@class,'quota_input')])[" + index + "]" + xpathForElementVisible;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil deleteIconForPollingAnswer(int index) {
        String xpath = "(//i[contains(@class,'remove_polling_answer')])[" + index + "]" + xpathForElementVisible;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil conferenceBridgeRadio = ByUtil.xpath("//input[starts-with(@id,'notificationType2')]" + xpathForElementVisible);
    
    public ByUtil conferenceBridgeSelect = ByUtil.xpath("//select[@name='message.conferenceBridgeId']" + xpathForElementVisible);
    
    public ByUtil attachFilesLink = ByUtil.xpath("//object[@class='swfupload']" + xpathForElementVisible);
    public ByUtil uploadProgress = ByUtil.xpath("//div[contains(@class,'uploadProgress')][last()]"+ xpathForElementVisible);
    
    public ByUtil testBtn = ByUtil.xpath("//input[@name='form_preview']" + xpathForElementVisible);
    
    
    public ByUtil searchInput = ByUtil.xpath("//input[@name='quickSearchValue']" + xpathForElementVisible);
    public ByUtil searchBtn = ByUtil.xpath("//button[starts-with(@id,'simpleSearch')]" + xpathForElementVisible);
    
    public ByUtil newVarialbesBtn = ByUtil.xpath("//button[starts-with(@id,'newVariable')]" + xpathForElementVisible);
    
    public ByUtil reqCb = ByUtil.xpath("//input[starts-with(@id,'cb_variableGrid')]" + xpathForElementVisible);
    
    public ByUtil variableNameLink = ByUtil.xpath("//div[@*[substring(., string-length() -12) = '_variableName']]" + xpathForElementVisible);
    
    public ByUtil useNotificationEscalationCb = ByUtil.xpath("//input[starts-with(@id,'useEscalationCheckbox')]" + xpathForElementVisible);
    public ByUtil totalResponsesNeededInput = ByUtil.xpath("//input[starts-with(@id,'confirmCountNeeded')]" + xpathForElementVisible);
    public ByUtil pollingOptionsSelect = ByUtil.xpath("//select[starts-with(@id,'pollingOptionNeeded')]" + xpathForElementVisible);
    public ByUtil addAnotherEscalationLevelLink = ByUtil.xpath("//a[starts-with(@id,'addNewEscalationLevel')]" + xpathForElementVisible);
    
    public ByUtil defaultBtn = ByUtil.xpath("//a[starts-with(@id,'defaultButton')]" + xpathForElementVisible);
    public ByUtil conditionBtn = ByUtil.xpath("//a[starts-with(@id,'conditionButton')]" + xpathForElementVisible);
    public ByUtil editOrHideLink = ByUtil.xpath("//a[starts-with(@id,'edit_link')]" + xpathForElementVisible);
    public ByUtil senderEmailDisplayInput = ByUtil.xpath("//input[@name='broadcastSettings.senderEmail']" + xpathForElementVisible);
    public ByUtil senderCallerIdInput(PhoneNumberEnum pne) {
        String xpath1 = "//*[starts-with(@id,'div_sendercallerid')]" + xpathForElementVisible 
                + "//input[@countrycode='" + pne.getCountryCode().toUpperCase() + "']";
        String xpath2 = "//li[starts-with(@id,'senderCallerIdContainer')]//div[text()='" + pne.getCountryName() + "']/following-sibling::input"  + xpathForElementVisible;
        String xpath = xpath1 + "|" + xpath2;
//		Helper.printStr(xpath);
        return ByUtil.xpath(xpath);
    }
    public ByUtil senderCallerIdViewLink = ByUtil.xpath("//a[starts-with(@id,'senderCallerTips')]" + xpathForElementVisible);
    public ByUtil deliveryOrderSelect = ByUtil.xpath("//select[starts-with(@id,'orderSelect')]" + xpathForElementVisible);
    public ByUtil deliveryMethodsSelect = ByUtil.xpath("//select[starts-with(@id,'deliverpathTypeSelect')]" + xpathForElementVisible);
    public ByUtil errorIcon_deliveryMethods = ByUtil.xpath("(//li[starts-with(@id,'deliveryMethodContainer')]//label[@class='error'])" + xpathForElementVisible);
    
    public ByUtil mobileMemberAppSettingsViewLink = ByUtil.xpath("//a[starts-with(@id,'recipientapp_showstr')]" + xpathForElementVisible);
    public ByUtil requestLocationCb = ByUtil.xpath("//input[@name='broadcastSettings.mobileSettings.requestLocation']" + xpathForElementVisible);
    public ByUtil requestAdditionalInformationCb = ByUtil.xpath("//input[@name='broadcastSettings.mobileSettings.requestComment']" + xpathForElementVisible);
    public ByUtil requestImageCb = ByUtil.xpath("//input[@name='broadcastSettings.mobileSettings.requestImage']" + xpathForElementVisible);
    public ByUtil enableSharingOptionsCb = ByUtil.xpath("//input[@name='broadcastSettings.mobileSettings.allowShare']" + xpathForElementVisible);
    
    public ByUtil applyVoiceDeliveryThrottlingRulesCb = ByUtil.xpath("//input[starts-with(@id,'isThrottle')]" + xpathForElementVisible);
    public ByUtil broadcaseDurationSelect = ByUtil.xpath("//select[@name='broadcastSettings.duration']" + xpathForElementVisible);
    public ByUtil contactCyclesSelect = ByUtil.xpath("//select[@name='broadcastSettings.contactCycles']" + xpathForElementVisible);
    public ByUtil intervalBetweenCyclesSelect = ByUtil.xpath("//select[@name='broadcastSettings.cycleInterval']" + xpathForElementVisible);
    public ByUtil intervalBetweenDeliveryMethodsSelect = ByUtil.xpath("//select[@name='broadcastSettings.deliveryMethodInterval']" + xpathForElementVisible);
    public ByUtil yesRadio_voiceDeliveryPin = ByUtil.xpath("//input[starts-with(@id,'voiceDeliveryPinYes')]");
    public ByUtil noRadio_voiceDeliveryPin = ByUtil.xpath("//input[starts-with(@id,'voiceDeliveryPinNo')]");
    public ByUtil messageOnlyRadio = ByUtil.xpath("//input[@value='MESSAGE_ONLY']" + xpathForElementVisible);
    public ByUtil messageWithConfirmationRadio = ByUtil.xpath("//input[@value='MESSAGE_WITH_CONFIRMATION']" + xpathForElementVisible);
    public ByUtil noMessageRadio = ByUtil.xpath("//input[@value='NO_MESSAGE']" + xpathForElementVisible);
    public ByUtil confirmCb = ByUtil.xpath("//input[starts-with(@id,'confirmview')']" + xpathForElementVisible);
    public ByUtil smsCallBackCb = ByUtil.xpath("//input[starts-with(@id,'confirmview')]" + xpathForElementVisible);
    public ByUtil languageSelect = ByUtil.xpath("//select[@name='broadcastSettings.language']" + xpathForElementVisible);
    
    /*
     * settings tab
     */
    public ByUtil messageViewCb = ByUtil.xpath("//input[@value='mv']" + xpathForElementVisible);
    public ByUtil messageEditCb = ByUtil.xpath("//input[@value='me']" + xpathForElementVisible);
    public ByUtil contactsViewCb = ByUtil.xpath("//input[@value='cv']" + xpathForElementVisible);
    public ByUtil contactsEditCb = ByUtil.xpath("//input[@value='ce']" + xpathForElementVisible);
    public ByUtil settingsViewCb = ByUtil.xpath("//input[@value='sv']" + xpathForElementVisible);
    public ByUtil settingsEditCb = ByUtil.xpath("//input[@value='se']" + xpathForElementVisible);
    public ByUtil addAnotherConditionLink = ByUtil.xpath("(//a[starts-with(@id,'addButton')]" + xpathForElementVisible + ")[1]");
    public ByUtil addAConditionBtn = ByUtil.xpath("(//button[starts-with(@id,'addButton')]" + xpathForElementVisible + ")[1]");
    
    public ByUtil addAnotherConditionLink_escalationLevel(int escalationLevelIndex) {
        return ByUtil.xpath(getXpathEscalationLi(escalationLevelIndex) + "//a[starts-with(@id,'addButton')]");
    }
    
    /**
     * @param useEscalation
     * @param escalationLevelIndex
     * <pre>
     *   0 : Primary Contact
     *   1 : Escalation Level 1
     *   2 : Escalation level 2
     *   3 : Escalation level 3
     *   and so on...
     * </pre>
     * @param contactConditionIndex
     *  <pre>
     *   0 : Static Contact
     *   1 : Contact Condition 1
     *   2 : Contact Condition 2
     *   3 : Contact Condition 3
     *   and so on...
     * @return
     * 
     * Example:
     * <pre>
     * contactsLink(false, 0, 0, ContactsTypeEnum.Individuals)
     * </pre>
     */
    public ByUtil contactsLink(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, ContactsTypeEnum cte) {
        String xpathContactsTypeLink = "//a";
        String xpathDiv = getXpathContactsLinkDiv(useEscalation, escalationLevelIndex, contactConditionIndex, cte);
//		Helper.printStr("(" + xpathDiv + ")" + xpathContactsTypeLink);
        return ByUtil.xpath("(" + xpathDiv + ")" + xpathContactsTypeLink);
    }
    
    public ByUtil contactsNum(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, ContactsTypeEnum cte) {
        String xpathContactsNum = "//strong";
        String xpathDiv = getXpathContactsLinkDiv(useEscalation, escalationLevelIndex, contactConditionIndex, cte);
        return ByUtil.xpath(xpathDiv + xpathContactsNum);
    }
    
    public ByUtil previewContactsLink(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathPreviewLink = "//*[starts-with(@id,'contactPreviewLink')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathPreviewLink);
    }
    
    public ByUtil conditionCopyIcon(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathCopyIcon = "//*[starts-with(@id,'copybtn')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathCopyIcon);
    }
    
    public ByUtil conditionCollapseIcon(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathCollapseIcon = "//*[starts-with(@id,'collapsebtn')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathCollapseIcon);
    }
    
    public ByUtil conditionExpandIcon(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathCollapseIcon = "//*[starts-with(@id,'collapsebtn')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathCollapseIcon);
    }
    
    public ByUtil conditionDeleteIcon(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathDeleteIcon = "//span[starts-with(@id,'deletebtn')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathDeleteIcon);
    }
    
    public ByUtil conditionNameInput(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
//		String xpathNameInput = "//input[@name='dynamicContactName']";
        String xpathNameInput = "//input[starts-with(@id,'conditionName')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathNameInput);
    }
    
    public ByUtil conditionIncidentVarSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xp = "//select[starts-with(@id,'variablesSelect')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
//		Helper.printStr("(" + xpathDiv + ")" + xp);
        return ByUtil.xpath("(" + xpathDiv + ")" + xp);
    }
    
    public ByUtil conditionMessageSenderValueInput(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathMsgSenderValueInput = "//*[@variableid='10001']/../..//input[@name='fieldValue']";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathMsgSenderValueInput);
    }
    
    public ByUtil conditionNotificationStatusValueSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathNotiStatusValueSelect = "//*[@variableid='10002']/../..//select[@name='fieldValue']";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathNotiStatusValueSelect);
    }
    
    /**
     * 
     * @param useEscalation
     * @param escalationLevelIndex
     * @param contactConditionIndex
     * @param valueSelectIndex
     *  <pre>
     *  1 : begin time select
     *  2 : begin time AMPM select
     *  3 : end time select
     *  4 : end time AMPM select
     *  </pre>
     * @return
     */
    public ByUtil conditionCurrentTimeValueSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, int valueSelectIndex) {
        String xpathCurrentTimeValueSelect = "//*[@variableid='10003']/../..//select[starts-with(@id,'fieldValue" + valueSelectIndex + "')]";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathCurrentTimeValueSelect);
    }
    
    public ByUtil conditionTodaysDateValueSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex) {
        String xpathTodaysDateValueSelect = "//*[@variableid='10004']/../..//select[@name='fieldValue']";
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        return ByUtil.xpath(xpathDiv + xpathTodaysDateValueSelect);
    }
    
    /**
     * EB : Everbridge default variable<br>
     * UD : user defined variable
     * @param useEscalation
     * @param escalationLevelIndex
     * @param contactConditionIndex
     * @param vte
     * @param UDVarName
     * @return
     */
    private String getXpathConditionVarTr(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, VariableEnum vte, String UDVarName) {
        String xpathDiv = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        String xpathIncidentCriteriaUDVarTr = "//input[@value='" + UDVarName + "']/../..";
        String xpathIncidentCriteriaEBVarTr = "";
        String xpath = "";
        switch (vte) {
            case EBMessageSender:
                xpathIncidentCriteriaEBVarTr = "//*[@variableid='" + EBVariablesIdEnum.MessageSender.getId() + "']/../..";
                xpath = xpathDiv + xpathIncidentCriteriaEBVarTr;
                break;
            case EBNotificationStatus:
                xpathIncidentCriteriaEBVarTr = "//*[@variableid='" + EBVariablesIdEnum.NotificationStatus.getId() + "']/../..";
                xpath = xpathDiv + xpathIncidentCriteriaEBVarTr;
                break;
            case EBCurrentTime:
                xpathIncidentCriteriaEBVarTr = "//*[@variableid='" + EBVariablesIdEnum.CurrentTime.getId() + "']/../..";
                xpath = xpathDiv + xpathIncidentCriteriaEBVarTr;
                break;
            case EBTodaysDate:
                xpathIncidentCriteriaEBVarTr = "//*[@variableid='" + EBVariablesIdEnum.TodaysDate.getId() + "']/../..";
                xpath = xpathDiv + xpathIncidentCriteriaEBVarTr;
                break;
            case UDVariable:
                xpath = xpathDiv + xpathIncidentCriteriaUDVarTr;
                break;
        }
        return xpath;
    }
    
    public ByUtil conditionIncidentCriteriaConditionSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, 
                                                                        VariableEnum vte, String UDVarName) {
        String xpathConditionSelect = "//select[starts-with(@id,'filterOption')]";
        String xpath = getXpathConditionVarTr(useEscalation, escalationLevelIndex, contactConditionIndex, vte, UDVarName)
                        + xpathConditionSelect;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil conditionIncidentCriteriaValueInput(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, 
            VariableEnum vte, String UDVarName) {
        String xpathValueInput = "//input[starts-with(@id,'fieldValue') or contains(@class,'ui-combobox-input')]";
        String xpath = getXpathConditionVarTr(useEscalation, escalationLevelIndex, contactConditionIndex, vte, UDVarName)
                + xpathValueInput;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil conditionIncidentCriteriaValueDropdownSpan(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, 
            VariableEnum vte, String UDVarName) {
        String xpathValueDropdownSpan = "//span[contains(@class,'ui-button-icon-primary')]";
        String xpath = getXpathConditionVarTr(useEscalation, escalationLevelIndex, contactConditionIndex, vte, UDVarName)
                + xpathValueDropdownSpan;
        Helper.printStr(xpath);
        return ByUtil.xpath(xpath);
    }
    
    /**
     * 
     * @param index
     * <br> start from 1
     * @return
     */
    public ByUtil conditionIncidentCriteriaValueDropdownItem(int index) {
        String xpath = "(//ul[starts-with(@id,'ui-id')]//li[contains(@class,'ui-menu-item')])[" + index + "]";
        return ByUtil.xpath(xpath);
    }
    
    /**
     * Example:<br>
     * <code>
     * conditionIncidentCriteriaValueDropdownItem("firstName lastName")
     * </code>
     * @param messageSenderFnLn
     * @return
     */
    public ByUtil conditionIncidentCriteriaValueDropdownItem(String messageSenderFnLn) {
        String xpath ="//ul[starts-with(@id,'ui-id')]//li[contains(@class,'ui-menu-item') and normalize-space()='" + messageSenderFnLn + "']//a";
        xpath = "(" + xpath + ")" + xpathForElementVisible;
        Helper.printStr(xpath);
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil conditionIncidentCriteriaValueSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, 
            VariableEnum vte, String UDVarName) {
        String xpathValueSelect = "//select[starts-with(@id,'fieldValue')]";
        String xpath = "(" + getXpathConditionVarTr(useEscalation, escalationLevelIndex, contactConditionIndex, vte, UDVarName) + ")"
                + xpathValueSelect;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil conditionIncidentCriteriaValueCurrentTimeSelect(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, 
            VariableEnum vte, String UDVarName, int selectIndex) {
        String xpathConditionSelect = "";
        switch(selectIndex) {
        case 1:
            xpathConditionSelect = "//select[starts-with(@id,'fieldValue1')]";
            break;
        case 2:
            xpathConditionSelect = "//select[starts-with(@id,'fieldValue2')]";
            break;
        case 3:
            xpathConditionSelect = "//select[starts-with(@id,'fieldValue3')]";
            break;
        case 4:
            xpathConditionSelect = "//select[starts-with(@id,'fieldValue4')]";
            break;
        }
        String xpath = getXpathConditionVarTr(useEscalation, escalationLevelIndex, contactConditionIndex, vte, UDVarName)
                + xpathConditionSelect;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil conditionIncidentCriteriaDelIcon(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, 
            VariableEnum vte, String UDVarName) {
        String xpathCriteriaDelIcon = "//i[starts-with(@class,'icn_trash')]";
        String xpath = getXpathConditionVarTr(useEscalation, escalationLevelIndex, contactConditionIndex, vte, UDVarName)
                        + xpathCriteriaDelIcon;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil escalationLevelNameEditIcon(int escalationLevelIndex) {
        String xpathEditIcon = "//a[starts-with(@id,'escalationNameEditSave')]";
        String xpath = getXpathEscalationLi(escalationLevelIndex) + xpathEditIcon;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil escalationLevelNameInput(int escalationLevelIndex) {
        String xpathNameInput = "//input[starts-with(@id,'escalationName')]";
        String xpath = getXpathEscalationLi(escalationLevelIndex) + xpathNameInput;
        return ByUtil.xpath(xpath);
    }
    public ByUtil escalationLevelNameSaveIcon(int escalationLevelIndex) {
        String xpathSaveIcon = "//a[starts-with(@id,'escalationNameEditSave')]";
        String xpath = getXpathEscalationLi(escalationLevelIndex) + xpathSaveIcon;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil escalationLevelWaitTimeInput(int escalationLevelIndex) {
        String xpathWaitTimeInput = "//input[starts-with(@id,'waitTime')]";
        String xpath = getXpathEscalationLi(escalationLevelIndex) + xpathWaitTimeInput;
        return ByUtil.xpath(xpath);
    }
    
    public ByUtil escalationLevelTimeUnitSelect(int escalationLevelIndex) {
        String xpathTimeUnitSelect = "//select[starts-with(@id,'timeUnit')]";
        String xpath = getXpathEscalationLi(escalationLevelIndex) + xpathTimeUnitSelect;
        return ByUtil.xpath(xpath);
    }
    
    /**
     * @param useEscalation
     * @param escalationLevelIndex
     * <pre>
     *   0 : Primary Contact
     *   1 : Escalation Level 1
     *   2 : Escalation level 2
     *   3 : Escalation level 3
     *   and so on...
     * </pre>
     * @param contactConditionIndex
     *  <pre>
     *   0 : Static Contact
     *   1 : Contact Condition 1
     *   2 : Contact Condition 2
     *   3 : Contact Condition 3
     *   and so on...
     * @return
     */
    private String getXpathContactsLinkDiv(Boolean useEscalation, int escalationLevelIndex, int contactConditionIndex, ContactsTypeEnum cte) {
        String xpath = "";
        String xpathIndividuals = "//div[@data-ref='type_individual']";
        String xpathGroups = "//div[@data-ref='type_group']";
        String xpathRules = "//div[@data-ref='type_filter']";
        String xpathMap = "//div[starts-with(@id,'mapview')]";
        
        xpath = getXpathContactsContainerDiv(escalationLevelIndex, contactConditionIndex);
        
        switch (cte) {  
            case Individuals:
                xpath = xpath + xpathIndividuals;
                break;  
            case Groups:
            	xpath = xpath + xpathGroups; 
                break;  
            case Rules:
            	xpath = xpath + xpathRules;  
                break; 
            case Map:
            	xpath = xpath + xpathMap;  
                break; 
        }
        return xpath;
    }
    
    public String getXpathEscalationLi(int escalationLevelIndex) {
        if (escalationLevelIndex == 0) {
            return "";
        }
        escalationLevelIndex++;
        return  "//ul[starts-with(@id,'multipleEscalationList')]" + xpathForElementVisible + "/li[" + escalationLevelIndex + "]";
    }
    
    /**
     * 
     * @param escalationLevelIndex
     * <pre>
     * -- 0 : Primary Contact
     * -- 1 : Escalation Level 1
     * -- 2 : Escalation Level 2
     * -- and so on...
     * </pre>
     * @param contactConditionIndex
     * <pre>
     * -- 0 : Static Contact
     * -- 1 : contact for first condition
     * -- 2 : contact for second condition
     * -- and so on...
     * </pre>
     * @return
     */
    private String getXpathContactsContainerDiv(int escalationLevelIndex, int contactConditionIndex) {
        String xpathEscalationLi = getXpathEscalationLi(escalationLevelIndex);
        String xpathContactContainerDiv = "";
        String xpath1 = "";
        String xpath2 = "";
        String xpath = "";
        if (contactConditionIndex == 0) {
            xpathContactContainerDiv = "//div[contains(@class,'staticContactContainer') or starts-with(@id,'staticContactContainer')]"  + xpathForElementVisible;
            return xpathEscalationLi + xpathContactContainerDiv;
        } else {
            // for contacts tab condition
            String xpathContactContainerDiv1 = xpathEscalationLi + "//div[@id][contains(@class,'dynamicContactContainer')]" + xpathForElementVisible;
            // for settings tab condition
            String xpathContactContainerDiv2 = xpathEscalationLi + "//div[contains(@class,'dynamicSettingContainer')]" + xpathForElementVisible;
            xpath1 = "(" + xpathContactContainerDiv1 + ")//li" + "[" + contactConditionIndex + "]";
            xpath2 = "(" + xpathContactContainerDiv2 + ")//li" + "[" + contactConditionIndex + "]";
            xpath = xpath1 + "|" + xpath2;
            return "(" + xpath + ")";
        }
        
    }
