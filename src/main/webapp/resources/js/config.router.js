'use strict';

/**
 * Config for the router
 */
app.config(['$stateProvider', '$urlRouterProvider', '$controllerProvider', '$compileProvider', '$filterProvider', '$provide', '$ocLazyLoadProvider', 'JS_REQUIRES',
function ($stateProvider, $urlRouterProvider, $controllerProvider, $compileProvider, $filterProvider, $provide, $ocLazyLoadProvider, jsRequires) {

    app.controller = $controllerProvider.register;
    app.directive = $compileProvider.directive;
    app.filter = $filterProvider.register;
    app.factory = $provide.factory;
    app.service = $provide.service;
    app.constant = $provide.constant;
    app.value = $provide.value;

    // LAZY MODULES

    $ocLazyLoadProvider.config({
        debug: false,
        events: true,
        modules: jsRequires.modules
    });

    // APPLICATION ROUTES
    // -----------------------------------
    // For any unmatched url, redirect to /app/home
    $urlRouterProvider.otherwise("/app/home");
    //
    // Set up the states
    $stateProvider.state('app', {
        url: "/app",
        templateUrl: "resources/views/app.html",
        resolve: loadSequence('modernizr', 'angularMoment', 'uiSwitch', 'perfect-scrollbar-plugin', 'toaster', 'ngAside', 'vAccordion', 'sweet-alert',
        		              'chartjs', 'tc.chartjs', 'oitozero.ngSweetAlert'),
        abstract: true
    }).state('app.home', {
        url: "/home",
        templateUrl: "resources/views/dummyApp/home.html",
        resolve: loadSequence('jquery-sparkline', 'dashboardCtrl'),
        title: 'Dashboard',
        ncyBreadcrumb: {
            label: 'Home'
        }
    }).state('app.userInfo', {
        url: "/userinfo",
        templateUrl: "resources/views/dummyApp/userinfo.html",
        resolve: loadSequence('UserInfoCtrl'),
        title: 'User Info',
        ncyBreadcrumb: {
            label: 'User Info'
        }
    }).state('app.clearTempFolder', {
        url: "/clearTempFolder",
        templateUrl: "resources/views/dummyApp/clearTempFolder.html",
        resolve: loadSequence('ClearTempFolderCtrl'),
        title: 'Clearing server temp folder...',
        ncyBreadcrumb: {
            label: ''
        }
    }).state('app.reports', {
        url: "/reports",
        templateUrl: "resources/views/dummyApp/reports.html",
        resolve: loadSequence('angularBootstrapNavTree', 'spin', 'angular-spinner', 'ladda', 'angular-ladda', 'ngTable', 'ngPable', 'ui.select',
        		              'jquery-ui', 'jquery-ui-multiselect-widget', 'angular-multiselect', 'reportsCtrl'),
        title: 'Reports',
        ncyBreadcrumb: {
            label: 'Reports'
        }
    }).state('app.reports.Scheduler', {
        url: "/Scheduler/:id",
        templateUrl: function($stateParams){
            return 'reports/Scheduler?id='+ $stateParams.id ;
        },
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'ui.select', 'schedulerCtrl', 'htmlToTrusted'),
        title: 'Scheduler',
        ncyBreadcrumb: {
            label: 'Scheduler'
        }
    }).state('app.reports.BGMReport', {
        url: "/BGMReport",
        templateUrl: "reports/BGMReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'ui.select', 'BGMReportCtrl', 'htmlToTrusted'),
        title: 'Benefit Grid Mass Report',
        ncyBreadcrumb: {
            label: 'Benefit Grid Mass Report'
        }
    }).state('app.reports.Tiering', {
        url: "/Tiering",
        templateUrl: "reports/Tiering",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'ui.select', 'tieringCtrl'),
        title: 'Tiering',
        ncyBreadcrumb: {
            label: 'Tiering'
        }
    }).state('app.reports.MacMsbMapping', {
        url: "/MacMsbMapping",
        templateUrl: "reports/MacMsbMapping",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'ui.select', 'macMsbMappingCtrl', 'angularFileUpload'),
        title: 'MacMsbMapping',
        ncyBreadcrumb: {
            label: 'MacMsbMapping'
        }
    }).state('app.reports.StandardVsTieredPOT', {
        url: "/StandardVsTieredPOT",
        templateUrl: "reports/StandardVsTieredPOT",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'ui.select', 'standardVsTieredPOTCtrl'),
        title: 'Standard vs Tiered POT Mapping',
        ncyBreadcrumb: {
            label: 'Standard vs Tiered POT Mapping'
        }
    }).state('app.reports.reportMLR', {
        url: "/reportMLR",
        templateUrl: "resources/views/dummyApp/mlrreports.html",
        resolve: loadSequence('ngTable', 'MLRCtrl'),
        title: ' MLR Reports',
        ncyBreadcrumb: {
            label: 'MLR Reports'
        }
    }).state('app.reports.reportCrosswalk', {
        url: "/reportCrosswalk",
        templateUrl: "reports/reportCrosswalk",
        resolve: loadSequence('ngTable', 'ui.select', 'alasql', 'xlsx', 'reportCrosswalkCtrl'),
        title: 'Report Crosswalk',
        ncyBreadcrumb: {
            label: 'Report Crosswalk'
        }
    })
    .state('app.MLR', {
        url: "/MLR",
        templateUrl: "reports/MLR",
        resolve: loadSequence('ngTable', 'MLRCtrl'),
        title: 'Report MLR',
        ncyBreadcrumb: {
            label: 'Report MLR'
        }
    }).state('app.reports.MLRReport', {
        url: "/MLRReport",
        templateUrl: "reports/MLRReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'mlrReportCtrl', 'ngSanitize'),
        title: 'Report MLR',
        ncyBreadcrumb: {
            label: 'Report MLR'
        }
    }).state('app.reports.ReportHMPS', {
        url: "/ReportHMPS",
        templateUrl: "reports/ReportHMPS",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'HMPSCtrl'),
        title: 'Report HPMS',
        ncyBreadcrumb: {
            label: 'HPMS Audit Report'
        }
    }).state('app.Encryption', {
        url: "/Encryption",
        templateUrl: "resources/views/dummyApp/Encryption.html",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'EncryptCtrl'),
        title: 'Encryption and Decryption',
        ncyBreadcrumb: {
            label: 'Password Encryption and Decryption'
        }
    }).state('app.reports.MedicaidCrosswalk', {
        url: "/MedicaidCrosswalk",
        templateUrl: "reports/MedicaidCrosswalk",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable',
        		              'spin', 'angular-spinner', 'angular-multiselect', 'MedicaidCrosswalkCtrl'),
        title: 'Medicaid Crosswalk',
        ncyBreadcrumb: {
            label: 'Medicaid Crosswalk'
        }
    }).state('app.reports.MongoPOC', {
        url: "/D2CTaggingTool",
        templateUrl: "reports/MongoPOC",
        resolve: loadSequence('spin', 'ui.select' , 'ladda', 'angular-ladda', 'jquery-ui', 'angularjs-dropdown-multiselect',
         'ngTable', 'angular-spinner', 'angular-multiselect', 'MongoPOCCtrl', 'checklist-model', 'angular-loading'),
        title: 'Medicare D2C Tagging Tool',
        ncyBreadcrumb: {
            label: 'Medicare D2C Tagging Tool'
        }
    }).state('app.reports.MedicalPDE', {
        url: "/MedicalPDE",
        templateUrl: "reports/MedicalPDE",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'ui.tree', 'xeditable', 'angularjs-dropdown-multiselect', 'MedicalPDECtrl',
        		              'ngSanitize', 'rangyCore', 'rangySel', 'rangyCla', 'InlineTextEditor'),
        title: 'Medical PDE Report Template',
        ncyBreadcrumb: {
            label: 'Medical PDE Report Template'
        }
    }).state('app.reports.MedicalPDETemplate', {
        url: "/MedicalPDETemplate",
        templateUrl: "reports/MedicalPDETemplate",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'ui.tree', 'xeditable','angularjs-dropdown-multiselect',
        		'MedicalPDETemplateCtrl', 'ngSanitize', 'rangyCore', 'rangySel', 'rangyCla', 'InlineTextEditor', 'angular-loading'),
        title: 'Medical PDE Report Template',
        ncyBreadcrumb: {
            label: 'Medical PDE Report Template'
        }
    }).state('app.reports.RxPDE', {
        url: "/RxPDE",
        templateUrl: "reports/RxPDE",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'ui.select', 'jquery-ui-multiselect-widget', 'RxPDECtrl'),
        title: 'Rx PDE Report',
        ncyBreadcrumb: {
            label: 'Rx PDE Report'
        }
    }).state('app.reports.RxPDETemplate', {
        url: "/RxPDETemplate",
        templateUrl: "reports/RxPDETemplate",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'ui.tree', 'xeditable', 'angularjs-dropdown-multiselect', 'ngSanitize', 'rangyCore',
        		              'rangySel', 'rangyCla', 'InlineTextEditor', 'RxPDETemplateCtrl'),
        title: 'Rx PDE Report Template',
        ncyBreadcrumb: {
            label: 'Rx PDE Report Template'
        }
    }).state('app.reports.RxDecision', {
        url: "/RxDecision",
        templateUrl: "reports/RxDecision",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'RxDecisionCtrl'),
        title: 'Rx Decision',
        ncyBreadcrumb: {
            label: 'Rx Decision'
        }
    })
    //120c
    .state('app.reports.HRIndividual', {
        url: "/HRIndividual",
        templateUrl: "reports/HRIndividual",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable',
        		              'spin', 'angular-spinner', 'angular-multiselect', 'hrIndividualCtrl'),
        title: 'Revision History Individual',
        ncyBreadcrumb: {
            label: 'Revision History Individual'
        }
    })
    .state('app.reports.RHGroup', {
        url: "/RHGroup",
        templateUrl: "reports/RHGroup",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget',
        		'ui.select', 'ngTable', 'spin', 'angular-spinner', 'angular-multiselect', 'rHGroupCtrl'),
        title: 'Revision History - Group',
        ncyBreadcrumb: {
            label: 'Revision History - Group'
        }
    })
    .state('app.reports.HRAdmin', {
        url: "/HRAdmin",
        templateUrl: "reports/HRAdmin",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'spin',
        		               'angular-spinner', 'angular-multiselect', 'hrAdministrationCtrl'),
        title: 'Revision History Administration',
        ncyBreadcrumb: {
            label: 'Revision History Administration'
        }
    })
    //End 120c
    .state('app.reports.DLR', {
        url: "/DLR",
        templateUrl: "reports/DLR",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'ui.select', 'alasql', 'xlsx', 'dlrCtrl', 'htmlToTrusted'),
        title: 'DLR',
        ncyBreadcrumb: {
            label: 'DLR'
        }
    }).state('app.reports.DXR', {
        url: "/DXR",
        templateUrl: "reports/DXR",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'ui.select', 'alasql', 'xlsx', 'dxrCtrl', 'htmlToTrusted'),
        title: 'DXR',
        ncyBreadcrumb: {
            label: 'DXR'
        }
    }).state('app.reports.reportMLR.MLRMedicalBenefitMapping', {
        url: "/MLRMedicalBenefitMapping",
        templateUrl: "reports/MLRMedicalBenefitMapping",
        resolve: loadSequence('ngTable', 'ui.select', 'alasql', 'xls', 'xlsx', 'MLRMedicalBenefitMappingCtrl'),
        title: 'Market Level Report Medical Benefit Mapping',
        ncyBreadcrumb: {
            label: 'Market Level Report Medical Benefit Mapping'
        },
        views: {
            "MLR": {
                templateUrl: "reports/MLRMedicalBenefitMapping"
            }
        }

    }).state('app.reports.reportMLR.MLRPharmacyBenefitMapping', {
        url: "/MLRPharmacyBenefitMapping",
        templateUrl: "reports/MLRPharmacyBenefitMapping",
        resolve: loadSequence('ngTable', 'ui.select', 'ngSanitize', 'MLRPharmacyBenefitMappingCtrl', 'htmlToTrusted'),
        title: 'Market Level Report Pharmacy Benefit Mapping',
        ncyBreadcrumb: {
            label: 'Market Level Report Pharmacy Benefit Mapping'
        },
        views: {
            "MLR": {
                templateUrl: "reports/MLRPharmacyBenefitMapping"
            }
        }
    }).state('app.reports.BDW', {
        url: "/BDW",
        templateUrl: "reports/BDW",
        resolve: loadSequence( 'bdwCtrl' ),
        title: 'Benefit Decision Workbook',
        ncyBreadcrumb: {
            label: 'Benefit Decision Workbook'
        }
    }).state('app.reports.unavailableReportSplash', {
        url: "/UnavailableReport",
        templateUrl: "reports/UnavailableReportSplash",
        resolve: loadSequence('unavailableReportSplashCtrl'),
        title: 'Unavailable Report',
        ncyBreadcrumb: {
            label: 'Unavailable Report'
        }
    }).state('app.MLRServiceList', {
        url: "/MLRServiceList",
        templateUrl: "reports/MLRServiceList",
        resolve: loadSequence('ngTable', 'MLRServiceListCtrl'),
        title: 'Market Level Report Service List',
        ncyBreadcrumb: {
            label: 'Service list'
        }
    }).state('app.reports.PBPListReport', {
        url: "/PBPListReport",
        templateUrl: "reports/PBPListReport",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'ngTable', 'PBPListReportCtrl'),
        title: 'PBP Report List',
        ncyBreadcrumb: {
            label: 'PBP list Report'
        }
    }).state('app.reports.ProviderDirectoryForm', {
        url: "/ProviderDirectoryForm",
        templateUrl: "reports/ProviderDirectoryForm",
        resolve: loadSequence( 'ProviderDirectoryFormCtrl', 'replaceWith' ),
        title: 'Provider Directory Form',
        ncyBreadcrumb: {
            label: 'ProviderDirectoryForm'
        }
    }).state('app.reports.PTCIRules', {
        url: "/PTCIRules",
        templateUrl: "reports/PTCIRules",
        resolve: loadSequence('spin','ui.select' ,'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget','ngTable',
        		              'spin', 'angular-spinner','angular-multiselect', 'ptciRulesCtrl'),
        title: 'PTCI Rules',
        ncyBreadcrumb: {
        	label: 'PTCI Rules'
        }
    }).state('app.reports.PLMProcess', {
        url: "/PLMProcess",
        templateUrl: "reports/PLMProcess",
        resolve: loadSequence('spin','ui.select' ,'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget','ngTable', 'spin',
        		               'angular-spinner','angular-multiselect', 'plmProcessCtrl'),
        title: 'PLM Process',
        ncyBreadcrumb: {
        	label: 'PLM Process'
        }
    }).state('app.reports.BAGReport', {
        url: "/BAGReport",
        templateUrl: "reports/BAGReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'BAGReportCtrl'),
        title: 'BAG Report',
        ncyBreadcrumb: {
            label: 'BAG Report'
        }
    }).state('app.reports.PDR', {
        url: "/PDR",
        templateUrl: "reports/PDR",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'PDRCtrl'),
        title: 'Product Definition Report',
        ncyBreadcrumb: {
            label: 'Product Definition Report'
        }
    }).state('app.reports.NPD', {
        url: "/NPD",
        templateUrl: "reports/NPD",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ui.select', 'ngTable', 'NPDReportCtrl'),
        title: 'Individual NPD Report',
        ncyBreadcrumb: {
            label: 'Individual NPD Report'
        }
    }).state('app.reports.GNPD', {
        url: "/GNPD",
        templateUrl: "reports/GNPD",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ui.select', 'ngTable', 'GNPDReportCtrl'),
        title: 'Group NPD Report',
        ncyBreadcrumb: {
            label: 'Group NPD Report'
        }
    }).state('app.reports.providerDirectoryDriver', {
        url: "/ProviderDirectoryDriver",
        templateUrl: "reports/ProviderDirectoryDriver",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'ui.select', 'ProviderDirectoryDriverReportCtrl'),
        title: 'Provider Directory Driver Report',
        ncyBreadcrumb: {
            label: 'Provider Directory Driver Report'
        }
    }).state('app.reports.APLMarketProminenceReport', {
        url: "/APLMarketProminenceReport",
        templateUrl: "reports/APLMarketProminenceReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'APLMarketProminenceReportCtrl'),
        title: 'APL Market Prominence Report',
        ncyBreadcrumb: {
            label: 'APL Market Prominence Report'
        }
    }).state('app.reports.annualEOCLISextract', {
        url: "/AnnualEOCLISExtract",
        templateUrl: "reports/AnnualEOCLISExtract",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'ui.select', 'AnnualEOCLISExtractCtrl'),
        title: 'EOCLIS Extract',
        ncyBreadcrumb: {
            label: 'EOCLIS Extract'
        }
    }).state('app.reports.ServiceArea', {
        url: "/ServiceArea/:id",
        templateUrl: function($stateParams){
            return 'reports/ServiceArea?id='+ $stateParams.id ;
        },
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'ServiceAreaReportCtrl'),
        title: 'Service Area Report',
        ncyBreadcrumb: {
            label: 'Service Area'
        }
    }).state('app.reports.PlanServiceAreaForAEReport', {
        url: "/PlanServiceAreaForAEReport",
        templateUrl: "reports/PlanServiceAreaForAEReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'PlanServiceAreaForAEReportCtrl'),
        title: 'Plan Service Area for AE Report',
        ncyBreadcrumb: {
            label: 'Plan Service Area for AE Report'
        }
    }).state('app.reports.ANOCReport', {
        url: "/ANOCReportPreview",
        templateUrl: "reports/ANOCReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ngTable', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ANOCReportCtrl', 'htmlToTrusted'),
        title: 'ANOC Report',
        ncyBreadcrumb: {
            label: 'ANOC Report'
        }
    }).state('app.Redirect', {
        url: "/Redirect",
        templateUrl: "reports/Redirect",
        resolve: loadSequence('RedirectCtrl'),
        title: 'Redirect Page',
        ncyBreadcrumb: {
            label: 'Redirect Page'
        }
    }).state('app.Downloader', {
        url: "/Downloader",
        templateUrl: "downloader",
        resolve: loadSequence('DownloaderCtrl'),
        title: 'Downloader',
        ncyBreadcrumb: {
            label: 'Downloader'
        }
    }).state('app.AccessDenied', {
        url: "/AccessDenied",
        templateUrl: "reports/AccessDenied",
        resolve: loadSequence(),
        title: 'Access Denied',
        ncyBreadcrumb: {
            label: 'Access Denied'
        }
    }).state('app.reports.reportMLR.MLRPartDGapCoverageMapping', {
        url: "/MLRPartDGapCoverageMapping",
        templateUrl: "reports/MLRPartDGapCoverageMapping",
        resolve: loadSequence('ngTable', 'ui.select', 'MLRPartDGapCoverageMappingCtrl'),
        title: 'MLR Part D Gap Coverage Mapping',
        ncyBreadcrumb: {
            label: 'MLR Part D Gap Coverage Mapping'
        },
        views: {
            "MLR": {
                templateUrl: "reports/MLRPartDGapCoverageMapping"
            }
        }
    }).state('app.settings', {
        url: '/settings',
        templateUrl: "resources/views/dummyApp/settings.html",
        title: 'Settings',
        ncyBreadcrumb: {
            label: 'Settings'
        }
    })
    .state('app.reports.PLDataFeedMapping', {
        url: "/PLDataFeedMapping",
        templateUrl: "reports/PLDataFeedMapping",
        resolve: loadSequence('spin', 'ui.select' , 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'spin',
        		              'angular-spinner', 'angular-multiselect', 'PLDataFeedMappingCtrl', 'PLDataFeedExcludedPlansCtrl'),
        title: 'Plan Load Data Feed Mapping',
        ncyBreadcrumb: {
            label: 'Plan Load Data Feed Mapping'
        }
    })
    .state('app.reports.PLDataFeedExcludedPlans', {
        url: "/PLDataFeedExcludedPlans",
        templateUrl: "reports/PLDataFeedExcludedPlans",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'spin', 'angular-spinner',
        		              'angular-multiselect', 'PLDataFeedExcludedPlansCtrl', 'PLDataFeedMappingCtrl'),
        title: 'Plan Load Data Feed Excluded Plans',
        ncyBreadcrumb: {
            label: 'Plan Load Data Feed Excluded Plans'
        }
    })
    .state('app.reports.PLDataExtractReport', {
        url: "/PLDataExtractReport",
        templateUrl: "reports/PLDataExtractReport",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable',
        		              'spin', 'angular-spinner', 'angular-multiselect', 'PLDataExtractReportCtrl'),
        title: 'Plan Load Data Feed Excluded Plans',
        ncyBreadcrumb: {
            label: 'Plan Load Data Extract Report'
        }
    })
    .state('app.reports.PLDataFeedMappingChangeLog', {
        url: "/PLDataFeedMappingChangeLog",
        templateUrl: "reports/PLDataFeedMappingChangeLog",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable',
        		            'angular-spinner', 'angular-multiselect', 'PLDataFeedMappingChangeLogCtrl'),
        title: 'Plan Load Data Feed Mapping Change Log',
        ncyBreadcrumb: {
            label: 'Plan Load Data Feed Mapping Change Log'
        }
    })
    .state('app.reports.PLDataFeedRevisionHistory', {
        url: "/PLDataFeedRevisionHistory",
        templateUrl: "reports/PLDataFeedRevisionHistory",
        resolve: loadSequence('spin', 'ui.select', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget',
        		              'ngTable', 'spin', 'angular-spinner', 'angular-multiselect', 'PLDataFeedMappingChangeLogCtrl'),
        title: 'Plan Load Data Feed Revision History',
        ncyBreadcrumb: {
            label: 'Plan Load Data Feed Revision History'
        }
    })
    .state('app.reports.RxDecisionMapping', {
        url: "/RxDecisionMapping",
        templateUrl: "reports/RxDecisionMapping",
        resolve: loadSequence('spin', 'ui.select' , 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ngTable', 'spin', 'angular-spinner',
        		              'angular-multiselect', 'RxDecisionMappingCtrl', 'angularFileUpload'),
        title: 'Rx Decision Mapping',
        ncyBreadcrumb: {
            label: 'Rx Decision Mapping'
        }
    }).state('app.reports.PLACrosswalkReport', {
        url: "/PLACrosswalk",
        templateUrl: "reports/PLACrosswalk",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'spin', 'angular-spinner',
        		               'angular-multiselect', 'PLACrosswalkReportCtrl', 'angularFileUpload'),
        title: 'PLA Crosswalk Report',
        ncyBreadcrumb: {
            label: 'PLA Crosswalk'
        }
    }).state('app.reports.GPIReport', {
        url: "/GPIReport",
        templateUrl: "reports/GPIReport",
        resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ui.select', 'ngTable', 'GPIReportCtrl'),
        title: 'GPI Report',
        ncyBreadcrumb: {
            label: 'GPI Report'
        }
  }).state('app.reports.ProviderDirectoryRevisionHistoryReport', {
      url: "/ProviderDirectoryRevisionHistoryReport",
      templateUrl: "reports/ProviderDirectoryRevisionHistoryReport",
      resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'jquery-ui', 'jquery-ui-multiselect-widget', 'ui.select', 'ngTable', 'spin',
    		                'angular-spinner', 'angular-multiselect','ProviderDirectoryRevisionHistoryReportCtrl'),
      title: 'Provider Directory Revision History',
      ncyBreadcrumb: {
          label: 'Provider Directory Revision History'
      }
  }).state('app.reports.ProviderDirectoryToDirectoryDesignerReport', {
      url: "/ProviderDirectoryToDirectoryDesignerReport",
      templateUrl: "reports/ProviderDirectoryToDirectoryDesignerReport",
      resolve: loadSequence('spin', 'ladda', 'angular-ladda', 'ui.select', 'ngTable'),
      title: 'Provider Directory To Directory Designer Report',
      ncyBreadcrumb: {
          label: 'Provider Directory To Directory Designer Report'
      }
});

    // Generates a resolve object previously configured in constant.JS_REQUIRES (config.constant.js)
    function loadSequence()
    {
        var _args = arguments;
        return {
            deps: ['$ocLazyLoad', '$q', '$rootScope',
            function ($ocLL, $q, $rootScope) {

                var promise = $q.when(1);
                for (var i = 0, len = _args.length; i < len; i++) {
                    promise = promiseThen(_args[i]);
                }
                return promise;

                function promiseThen(_arg) {

                    if (typeof _arg == 'function')
                        return promise.then(_arg);
                    else
                        return promise.then(function () {

                            var nowLoad = requiredData(_arg);
                            if (!nowLoad)
                                return $.error('Route resolve: Bad resource name [' + _arg + ']');
                            return $ocLL.load(nowLoad);
                        });
                }

                function requiredData(name) {
                    $rootScope.validSession();

                    if (jsRequires.modules)
                        for (var m in jsRequires.modules)
                            if (jsRequires.modules[m].name && jsRequires.modules[m].name === name)
                                return jsRequires.modules[m];
                    return jsRequires.scripts && jsRequires.scripts[name];
                }
            }]
        };
    }
}]);
