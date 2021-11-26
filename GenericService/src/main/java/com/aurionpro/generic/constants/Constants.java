package com.aurionpro.generic.constants;

public final class Constants {

	// Newly Added For Charge Retrial - Deep Upadhye
	public static final String LASTRETRYATTEMPTDATETIME = "LastRetryAttemptDateTime";
	public static final String RETRYSTATUS = "RetryStatus";
	public static final String CHARGEINTERVAL = "Charge Interval";
	public static final String NOOFRETRIES = "No. Of Retries";
	public static final String AUTOBATCH = "AUTOBATCH";
	public static final String ENCODED_SEARCHVALUE = "'";
	public static final String ENCODED_SEARCHVALUE1 = "~";
	public static final String AUTHORIZATION_MATRIX = "AUTHORIZATION_MATRIX";
	public static final String AUTHORIZATION_RULES = "AUTHORIZATION_RULES";
	public static final String SESSIONID = "SESSIONID";
	public static final String SYSTEM_USER = "System";

	public static final String RESULTS_PAGESIZE = "results.pagesize";

	public static final String INST_RESULTS_PAGESIZE = "instrumentQuerryresults.pagesize";

	public static final String CACHE_CLEANUP_TIME = "cache.cleanup.time";
	public static final String CACHE_KEEPALIVE_KEYS = "cache.keepAlive.keys";

	public static final String ISEODBODRUNNING = "ISEODBODRUNNING";
	public static final String CACHE_TIME = "cache.time";
	public static final String MAKERCHECKER = "MAKERCHECKER";
	public static final String AUTHORIZATIONMATRIX = "AUTHORIZATIONMATRIX";
	public static final String BOARDRESOLUTION = "BOARDRESOLUTION";
	public static final String SELFAUTHORIZATION = "SELFAUTHORIZATION";
	public static final String AUTHORIZATIONLEVEL = "AUTHORIZATIONLEVEL";
	public static final String CURRENTCORPORATEBRANCHID = "CURRENTCORPORATEBRANCHID";
	public static final String CURRENTCORPORATEBRANCHNAME = "CURRENTCORPORATEBRANCHNAME";
	public static final String LOGINCORPORATEBRANCHID = "LOGINCORPORATEBRANCHID";
	public static final String LOGINCORPORATEBRANCHNAME = "LOGINCORPORATEBRANCHNAME";
	public static final String CORPORATEBRANCHHUB = "CORPORATEBRANCHHUB";
	public static final String ACROSSBRANCHAUTHORIZATION = "ACROSSBRANCHAUTHORIZATION";
	public static final String RBISPECIFICECSUPLOAD = "RBISPECIFICECSUPLOAD";
	public static final Long corporateBranchStartId = 100000L;
	public static final Long otherBankBranchStartId = 100000L;
	public static final Long corporateMainId = 100000L;
	public static final Integer UNKNOWN_LANGUAGE_CODE = -1;
	public static final Integer ENG_LANGUAGE_CODE = 0;
	public static final Integer ARABIC_LANGUAGE_CODE = 1;

	public static final Long systemBankId = 1L;
	public static final Integer DEFAULT_INSTRUMENTLENGTH = 10;
	public static final Integer DEFAULT_SHORTACCOUNTNOLENGTH = 6;

	public static final Integer DEFAULT_ACCOUNTNOMINLENGTH = 6;
	public static final Integer DEFAULT_ACCOUNTNOMAXLENGTH = 15;
	public static final Long BRANCHID = 1L;
	public static final String BRANCHNAME = "BRANCHNAME";
	public static final String CUTOFFTIMEEXCEEDED = "CUTOFFTIMEEXCEEDED";
	public static final String SPECIALREQUESTBATCHNO = "SPREQBATCHNO";
	public static final String EXTERNALAPPLICATIONNAME = "EXTERNALAPPLICATIONNAME";
	public static final String ISGROUPUSER = "ISGROUPUSER";
	/**
	 * Added by Vijay Chauhan on 1 Feb, 2011 for Self Authorisation & Limit for
	 * Corporate User
	 */
	public static final String USERAUTHTYPE = "USERAUTHTYPE";
	public static final String SELFAUTHLIMIT = "SELFAUTHLIMIT";
	public static final String SELFAUTHORIZATION_ACCOUNT_WITH_LIMIT = "SELFAUTHORIZATION_ACCOUNT_WITH_LIMIT";

	/**
	 * added by sarika for super user CR
	 */
	public static final String MASTERSELFAUTH = "MASTERSELFAUTH";
	public static final String TRANSACTIONSELFAUTH = "TRANSACTIONSELFAUTH";
	public static final String SELFSERVICESELFAUTH = "SELFSERVICESELFAUTH";

	public static final String HOSTAUTHENTICATIONCODE = "HOSTAUTHENTICATIONCODE";
	public static final String CHEQUE_REPRINTING = "CHEQUE_REPRINTING";
	public static final String CORPORATEADMINISTRATORBY = "CORPORATEADMINISTRATORBY";

	public static final String ENTITNAME_CORP_MAIN = "CORPORATEMAIN";

	public static final String ENTITNAME_VENDOR = "VENDOR";

	public static final String IDCreatedOn = "IDCreatedOn";
	/**
	 * Added by Vijay Chauhan on 27 Sep, 2011 for Old and New Value START
	 */
	public static final String oldAndNewValue_In_LastAction = "'create Authorized', "
			+ "'update','update Authorized','update Rejected'," + "'delete','delete Rejected'"
			+ "'disable','disable Rejected'" + "'enable Authorized'";

	public static final String oldAndNewValue_NotIn_LastAction = "'save','create','create Rejected','enable','enable Rejected', 'disable Authorized'";

	public static final String oldAndNewValueSpec = "lastAction not in (" + oldAndNewValue_NotIn_LastAction + ")";

	public static final String oldAndNewValueSpecForSuperUser = "lastAction not in ('save','create','create Rejected','enable','enable Rejected', 'disable Authorized')";

	/**
	 * END
	 */
	// added by sachin gore 30 Dec 2013 EJB changes
	public static final String APPCONFIGFOLDERPATH = "app.config";
	public static final String APPCONFIGFOLDERPATHCLUSTER = "app.config.cluster";
	public static final String ISCLUSTERREQUIRED = "app.config.isCluster";
	public static final String COMMONS = "commons";
	public static final String PAYPRO = "payments";
	public static final String COLLECTPRO = "collectpro";
	public static final String ECS = "MandatePro";
	public static final String LMS = "lms";
	public static final String PDC = "pdc";
	public static final String FSCM = "fscm";
	public static final String KYC = "kyc";
	public static final String AML = "aml";
	public static final String SYSTEM = "SYSTEM";
	public static final String REPORT = "reports";
	public static final String VAM = "VAM";
	public static final String VIRTUALACCOUNT = "virtualAccount";
	public static final String TRADE = "trade";
	public static final String RMS = "rms";

	/*
	 * Code added by Yogesh new constant introduced to check
	 * h2hauthorizationrequired flag for V begin
	 */
	public static final String VALIDATEAUTHORIZATION = "VALIDATEAUTHORIZATION";
	public static final String VALIDATEAUTHORIZATIONVAL = "V";
	public static final String H2HFILEPROCESSING = "H2H File Processing";
	/*
	 * Code added by Yogesh new constant introduced to check
	 * h2hauthorizationrequired flag for V end
	 */

	public static final String REPROCESS = "REPROCESS";
	public static final String AUTHTYPE = "AUTHTYPE";
	public static final String ACTIVATETOKENTYPE = "activateTokenType";

	public static final Integer DEFAULTMAXQUICKLINKCOUNT = 10;

	public static final String ACTIVATIONURL = "activationURL";
	public static final String PASSWORD = "password";
	public static final String NOOFEXPIRYDAYS = "noOfExpiryDays";

	public static final String SMSOTP = "smsOTP";
	public static final String OTPSTATUS = "OTPSTATUS";

	public static final String EMAILOTP = "emailOTP";
	public static final String OTP = "otp";

	public static final Integer ENCRYPTION_KEY = 95;
	public static final Integer OTP_TYPE = 1003;
	public static final Integer OTP_EXPIRE = 65;
	public static final Integer OTP_NOOFRETRY = 6;// 1005;

	public static final Integer MAKERCHECKERFOR_TEMPLATEMGMT = 8007;
	public static final Integer NO_OF_QUESTIONS = 1000099;

	public static final String USERACTIVATION = "USERACTIVATION";

	public static final String USERACTIVATION_MESSAGE = "User Activation is successful.";
	public static final String USERACTIVATION_FAILED = "User Activation is failed.";

	public static final String SENDACTIVATIONLINK = "SENDACTIVATIONLINK";
	public static final String SENDACTIVATIONLINK_MESSAGE = "Sent activation link";
	public static final String SENDACTIVATIONLINK_FAILMESSAGE = "Sent activation link Failed";

	public static final Integer ISRUNTIMEBENEFICIARYINSERT = 10017;

	public static final String LOADUISTATUS = "loadUIStatus";

	public static final String LOADUISTATUSFROMDB = "DB";
	public static final String LOADUISTATUSFROMCSV = "CSV";

	public static final String AUTHORIZED = "Authorized";
	public static final String UNAUTHORIZED = "UnAuthorized";
	public static final String REJECTED = "Rejected";
	public static final String DISABLED = "Disabled";

	public static final String LOGINADVERTISEMENTIMAGEPATH = "cms.login.advertisementimage";
	public static final String FOOTERUPLOADPATH = "cms.footer";

	public static final String LOGOUTADVERTISEMENTIMAGEPATH = "cms.logout.advertisementimage";

	public static final String LANDINGADVERTISEMENTIMAGEPATH = "cms.landing.advertisementimage";
	public static final String CMS_LANDING_ACTUAL_ADVERTISEMENT_MODIFIED_IMAGE = "cms.landing.actual.advertisementimage";
	public static final String PUBLICKEY = "abcdefghijklmop";

	public static final String SUB_MODULE = "subModule";
	public static final String SUB_MODULE_ID = "subModuleId";
	public static final String SUB_MODULE_NAME = "subModuleName";
	public static final String MODULE = "module";
	public static final String MODULE_ID = "moduleId";
	public static final String MODULE_NAME = "moduleName";
	public static final String MODULE_NAME_TITLE = "Module Name";
	public static final String DEFAULT_CHARGE_ACCOUNT = "Default Charge Account";
	public static final String PROMOTIONAL_CHARGE_GROUP = "Promotional Charge Group";
	public static final String CHARGE_GROUP = "Normal Charge Group";
	public static final String CHARGE_APPLICABLE = "Charge Applicable";
	public static final String PARAM_KEYS = "paramKeys";
	public static final String VERIFICATION_REQ = "Verification required";
	public static final String VERIFICATION_LEVEL = "Verification Level";
	public static final String NO_OF_VERIFIER = "Total Verifiers";

	public static final String BASECURRENCYAMOUNT = "baseCurrencyAmount";
	public static final String BASEEXCHANGERATE = "baseExchangeRate";
	public static final String BASECURRENCYID = "baseCurrencyId";

	public static final String BASEBATCHCURRENCYAMOUNT = "baseBatchCurrencyAmount";
	public static final String BASEBATCHEXCHANGERATE = "baseBatchExchangeRate";
	public static final String BASEBATCHCURRENCYID = "baseBatchCurrencyId";
	public static final String PROMISSORYNOTE = "PromissoryNote";

	public static final String ISCARDREQUIRED_PARAM = "90922";
	public static final Integer ISCARDINTERFACERUNNING_PARAM = 90925;

	public static final Integer CURRENCYWISEAUTHMATRIX = 4002;
	public static final Integer CORPORATEWISEAUTHMATRIX = 4003;
	public static final Integer AUTHMATRIXBASEDONDEBITORPAYABLE = 4000;
	public static final String VERIFIERREQUIRED = "Y";

	public static final String ISBRNUMBERREQUIRED_PARAM = "90921";

	public static final String CREDITCARD_STATEMENTMONTH = "creditcard.statementmonth";

	public static final Integer PAYMENTMETHODWISEHHOLIDAY = 99999;

	public static final Integer CHARGEPARAMETERREQUIRED = 1021;
	public static final Integer CURRENCYWISECHARGEPARAMETER = 1022;
	public static final Integer BASECURRENCYCHARGEREQUIRED = 1025;

	public static final Integer CENTRALBANKCHARGEREQUIRED = 1027;
	public static final Integer CENTRALBANKCHARGEAMOUNT = 1028;

	public static final Integer CARDNUMBERLENGTHFORINTERFACE = 90927;
	public static final Integer CARDNUMBERMASKINGREQUIRED = 90928;

	public static final Integer ISMASKEDREQUIRED = 90929;
	public static final Integer MASKEDSTARTLEN = 90930;
	public static final Integer MASKENDLEN = 90931;
	public static final Integer CARDMASKCHAR = 90932;
	public static final String WAIVER_EFFECTIVETILL = "01-Jan-2030";
	public static final String CREDITNOTE = "CreditNote";
	public static final String DEBITNOTEPAYMENTRECEIPT = "DebitNotePaymentReceipt";
	public static final Integer ARCHIVAL_PARAMKEY = 99;
	public static final Integer CARD_STATEMENT_MONTH = 90923;
	public static final Integer OTP_EXPIRE_CASHPAY = 10106;

	public static final String PAYMENTS = "Payments";
	public static final String COLLECTIONS = "Collections";
	public static final String VACC = "VAM";

	public static final String GUARANTEED = "Guaranteed";

	private Constants() {
	}

	public static final String SETUP = "SetUp";

	public static final Integer BASECURRENCYCODE = 26;
	public static String VOLUMEBATCHTYPE = "29";
	public static final Integer ACCOUNT_ALLOWED_FOR_TXN = 911;// It is saved as -911 in db

	public static final Integer PARAM_HIDE_SELECT_AUTHORIZER_SCREEN = 2025;
	public static final Integer ISMULTILEVELSELECTAUTH = 2026;

	public static final Integer PARAM_HIDE_SELECT_VERIFIER_SCREEN = 2039;
	public static final Integer ISMULTILEVELSELECTVERIFIER = 2040;
	public static final Integer UPDATESYATEMDELETESTATUSDAYS = 20360;
	public static final Integer INSUFFICIENTFUNDVALIDATION = 912;
	public static String MASKINGING_PARAMETER = "Y";
	public static final Integer CORPPRODTEMPLATEORDATALAYOUTBASED = 6100;
	public static final Integer CORPPRODFILENAMEPREFIXLENGTH = 6101;
	public static final Integer MAXCORPPRODDATALAYOUTALLOWED = 6102;
	public static final Integer USERTEMPLATEREQUIRED = 6200;
	public static final Integer PRODUCTINTRANSACTION = 4004;
	public static final Integer TYPEIDFORSERVICEREQUESTSUBMODULE = 913;

	public static final String VAT = "VAT";

	public static final Integer CORPORATEVASTRUCTUREACCACCESS = 91911;
	public static final Integer VAISSUANCEACCACCESS = 91912;
	public static final Integer VAISSUANCEUPLOADACCACCESS = 91913;
	public static final Integer VASTATUSMANAGEMENTACCACCESS = 91914;
	public static final Integer VAMENQUIRYACCACCESS = 91915;
	public static final Integer VAMREPORTSACCACCESS = 91916;
	public static final Integer VAMWIDGETSACCACCESS = 91917;
	

	public static final Integer FILENAMEPREFIXLENGTH = 6101;
	public static final String DRAFT_LISTING = "draft";

	// Operation Type
	public static final String OPERATION_REMITTANCE = "Remittance";

	public static final Integer PINCODEMAXLENGTH = 6;
	public static final Integer PINCODEMINLENGTH = 5;

	
	
	public static final String CONSOLIDATEUPLOAD = "CONSOLIDATEUPLOAD";
	public static final String CHEQUEUPLOADCONSOLIDATED = "CHEQUEUPLOADCONSOLIDATED";
	public static final String CHEQUEDATAENTRYCONSOLIDATEDUPLOAD = "CHEQUEDATAENTRYCONSOLIDATEDUPLOAD";
	public static final String CHEQUEUPLOAD = "CHEQUEUPLOAD";
	public static final String CHEQUEDATAENTRYUPLOAD = "CHEQUEDATAENTRYUPLOAD";
}
	
