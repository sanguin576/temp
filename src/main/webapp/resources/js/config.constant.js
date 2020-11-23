'use strict';

/**
 * Config constant
 */
app.constant('APP_MEDIAQUERY', {
    'desktopXL': 1200,
    'desktop': 992,
    'tablet': 768,
    'mobile': 480
});
app.constant('JS_REQUIRES', {
    //*** Scripts
    scripts: {
        //*** Javascript Plugins
        'modernizr': ['resources/vendor/components-modernizr/modernizr.js'],
        'spin': 'resources/vendor/spin.js/spin.js',
        'angular-spinner': 'resources/vendor/spin.js/angular-spinner.js',
        'rangyCore': ['resources/vendor/rangy/rangy-core.js'],
        'rangySel': ['resources/vendor/rangy/rangy-selectionsaverestore.js'],
        'rangyCla': ['resources/vendor/rangy/rangy-classapplier.js'],
        //*** jQuery Plugins
        'perfect-scrollbar-plugin': ['resources/vendor/perfect-scrollbar/js/min/perfect-scrollbar.jquery.min.js',
                                     'resources/vendor/perfect-scrollbar/css/perfect-scrollbar.min.css'],
        'ladda': ['resources/vendor/ladda/dist/ladda.min.js', 'resources/vendor/ladda/dist/ladda-themeless.min.css'],
        'sweet-alert': ['resources/vendor/sweetalert/lib/sweet-alert.min.js', 'resources/vendor/sweetalert/lib/sweet-alert.css'],
        'chartjs': 'resources/vendor/chartjs/Chart.min.js',
        'jquery-sparkline': 'resources/vendor/jquery.sparkline.build/dist/jquery.sparkline.min.js',
        'ckeditor-plugin': 'resources/vendor/ckeditor/ckeditor.js',
        'jquery-nestable-plugin': ['resources/vendor/jquery-nestable/jquery.nestable.js'],
        'touchspin-plugin': ['resources/vendor/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js',
                             'resources/vendor/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css'],
        'jquery-ui': ['resources/vendor/jquery-ui/jquery-ui.min.js', 'resources/vendor/jquery-ui/jquery-ui.min.css', 'resources/vendor/jquery-ui/jquery-ui.structure.min.css',
                      'resources/vendor/jquery-ui/jquery-ui.theme.min.css'],
        'jquery-ui-multiselect-widget': ['resources/vendor/jquery-ui-multiselect-widget/src/jquery.multiselect.min.js',
                                         'resources/vendor/jquery-ui-multiselect-widget/src/jquery.multiselect.filter.min.js' ,
                                         'resources/vendor/jquery-ui-multiselect-widget/jquery.multiselect.css',
                                         ,'resources/vendor/jquery-ui-multiselect-widget/jquery.multiselect.filter.css'],
        'angular-multiselect': ['resources/vendor/angular-multiselect/multiple-select.min.js', 'resources/vendor/angular-multiselect/multiple-select.min.css'],
        'angular-loading': ['resources/vendor/angular-loading/angular-loading.js', 'resources/vendor/angular-loading/angular-loading.css'],
        //*** Controllers
        'dashboardCtrl': 'resources/js/controllers/dashboardCtrl.js',
        //*** Filters
        'htmlToPlaintext': 'resources/js/filters/htmlToPlaintext.js',
        'htmlToTrusted': 'resources/js/filters/htmlToTrusted.js',
        'replaceWith': 'resources/js/filters/replaceWith.js',
        //*** dummyApp Controllers
        //'dummyAppTaskCtrl': 'resources/js/controllers/dummyApp/tasksCtrl.js',
        'bookMarksCtrl': 'resources/js/controllers/dummyApp/bookmarksCtrl.js',
        'reportsCtrl': 'resources/js/controllers/dummyApp/reportsCtrl.js?timestamp=' + new Date().getTime(),
    	'reportCrosswalkCtrl': 'resources/js/controllers/dummyApp/reportCrosswalkCtrl.js',
    	'MLRCtrl': 'resources/js/controllers/dummyApp/MLRCtrl.js',
    	'RxDecisionReportCtrl': 'resources/js/controllers/dummyApp/RxDecisionReportCtrl.js',
    	'MLRMedicalBenefitMappingCtrl': 'resources/js/controllers/dummyApp/MLRMedicalBenefitMappingCtrl.js',
    	'MLRPharmacyBenefitMappingCtrl': 'resources/js/controllers/dummyApp/MLRPharmacyBenefitMappingCtrl.js',
    	'PBPListReportCtrl': 'resources/js/controllers/dummyApp/PBPListReportCtrl.js',
    	'MLRPartDGapCoverageMappingCtrl': 'resources/js/controllers/dummyApp/MLRPartDGapCoverageMappingCtrl.js',
    	'RedirectCtrl': 'resources/js/controllers/dummyApp/RedirectCtrl.js',
    	'dlrCtrl': 'resources/js/controllers/dummyApp/dlrCtrl.js',
    	'dxrCtrl': 'resources/js/controllers/dummyApp/dxrCtrl.js',
		'BGMReportCtrl': 'resources/js/controllers/dummyApp/BGMReportCtrl.js',
		'schedulerCtrl': 'resources/js/controllers/dummyApp/schedulerCtrl.js',
		'tieringCtrl': 'resources/js/controllers/dummyApp/tieringCtrl.js',
		'macMsbMappingCtrl': 'resources/js/controllers/dummyApp/macMsbMappingCtrl.js',
		'standardVsTieredPOTCtrl': 'resources/js/controllers/dummyApp/standardVsTieredPOTCtrl.js',
    	'bdwCtrl': 'resources/js/controllers/dummyApp/bdwCtrl.js',
		'mlrReportCtrl': 'resources/js/controllers/dummyApp/mlrReportCtrl.js',
		'HMPSCtrl': 'resources/js/controllers/dummyApp/HMPSCtrl.js',
		'RxDecisionCtrl': 'resources/js/controllers/dummyApp/RxDecisionCtrl.js',
		'unavailableReportSplashCtrl': 'resources/js/controllers/dummyApp/unavailableReportSplashCtrl.js',
		'BAGReportCtrl': 'resources/js/controllers/dummyApp/BAGReportCtrl.js',
		'ANOCReportCtrl': 'resources/js/controllers/dummyApp/ANOCReportCtrl.js',
		'NPDReportCtrl': 'resources/js/controllers/dummyApp/NPDReportCtrl.js',
		'GNPDReportCtrl': 'resources/js/controllers/dummyApp/GNPDReportCtrl.js',
		'ServiceAreaReportCtrl': 'resources/js/controllers/dummyApp/ServiceAreaReportCtrl.js',
        'PlanServiceAreaForAEReportCtrl': 'resources/js/controllers/dummyApp/PlanServiceAreaForAEReportCtrl.js',
		'ProviderDirectoryDriverReportCtrl': 'resources/js/controllers/dummyApp/ProviderDirectoryDriverReportCtrl.js',
        'APLMarketProminenceReportCtrl': 'resources/js/controllers/dummyApp/APLMarketProminenceReportCtrl.js',
		'AnnualEOCLISExtractCtrl': 'resources/js/controllers/dummyApp/AnnualEOCLISExtractCtrl.js',
		'EncryptCtrl': 'resources/js/controllers/dummyApp/EncryptCtrl.js',
		'MedicaidCrosswalkCtrl': 'resources/js/controllers/dummyApp/MedicaidCrosswalkCtrl.js',
		'MongoPOCCtrl': 'resources/js/controllers/dummyApp/MongoPOCCtrl.js',
		'MedicalPDECtrl': 'resources/js/controllers/dummyApp/MedicalPDECtrl.js',
		'MedicalPDETemplateCtrl': 'resources/js/controllers/dummyApp/MedicalPDETemplateCtrl.js',
		'RxPDECtrl': 'resources/js/controllers/dummyApp/RxPDECtrl.js',
		'RxPDETemplateCtrl': 'resources/js/controllers/dummyApp/RxPDETemplateCtrl.js',
		'GPIReportCtrl': 'resources/js/controllers/dummyApp/GPIReportCtrl.js',
		'ProviderDirectoryRevisionHistoryReportCtrl': 'resources/js/controllers/dummyApp/ProviderDirectoryRevisionHistoryReportCtrl.js',
		//120c
		'hrIndividualCtrl': 'resources/js/controllers/dummyApp/hrIndividualCtrl.js',
		'rHGroupCtrl': 'resources/js/controllers/dummyApp/rHGroupCtrl.js',
		'hrAdministrationCtrl': 'resources/js/controllers/dummyApp/hrAdministrationCtrl.js',
		'ProviderDirectoryFormCtrl': 'resources/js/controllers/dummyApp/ProviderDirectoryFormCtrl.js',
		'ptciRulesCtrl': 'resources/js/controllers/dummyApp/ptciRulesCtrl.js',
		'plmProcessCtrl': 'resources/js/controllers/dummyApp/plmProcessCtrl.js',
		//End 120c
		'PDRCtrl': 'resources/js/controllers/dummyApp/PDRCtrl.js',
		'UserInfoCtrl': 'resources/js/controllers/dummyApp/UserInfoCtrl.js',
		'DownloaderCtrl': 'resources/js/controllers/dummyApp/DownloaderCtrl.js',
		'ClearTempFolderCtrl': 'resources/js/controllers/dummyApp/ClearTempFolderCtrl.js'
		//Mocks
		,
		'PLDataFeedMappingCtrl': 'resources/js/controllers/dummyApp/PLDataFeedMappingCtrl.js'
		,
		'PLDataFeedExcludedPlansCtrl': 'resources/js/controllers/dummyApp/PLDataFeedExcludedPlansCtrl.js'
		,
		'PLDataExtractReportCtrl': 'resources/js/controllers/dummyApp/PLDataExtractReportCtrl.js'
		,
		'PLDataFeedMappingChangeLogCtrl': 'resources/js/controllers/dummyApp/PLDataFeedMappingChangeLogCtrl.js'
		,
		'PLDataFeedRevisionHistoryCtrl': 'resources/js/controllers/dummyApp/PLDataFeedRevisionHistoryCtrl.js'
		,
		'PLACrosswalkReportCtrl': 'resources/js/controllers/dummyApp/PLACrosswalkReportCtrl.js'
		//End-Mocks
		//122b
		,'RxDecisionMappingCtrl': 'resources/js/controllers/dummyApp/RxDecisionMappingCtrl.js'
		, 'filestyle' :'resources/vendor/bootstrap-filestyle/bootstrap-filestyle.min.js'
		//End-122b
    },
    //*** angularJS Modules
    modules: [{
        name: 'angularMoment',
        files: ['resources/vendor/angular-moment/angular-moment.min.js']
    }, {
        name: 'toaster',
        files: ['resources/vendor/AngularJS-Toaster/toaster.js', 'resources/vendor/AngularJS-Toaster/toaster.css']
    }, {
        name: 'angularBootstrapNavTree',
        files: ['resources/vendor/angular-bootstrap-nav-tree/dist/abn_tree_directive.js', 'resources/vendor/angular-bootstrap-nav-tree/dist/abn_tree.css']
    }, {
        name: 'angular-ladda',
        files: ['resources/vendor/angular-ladda/dist/angular-ladda.min.js']
    }, {
        name: 'ngTable',
        files: ['resources/vendor/ng-table/dist/ng-table.min.js', 'resources/vendor/ng-table/dist/ng-table.min.css']
    }, {
        name: 'ngPable',
        files: ['resources/vendor/ng-table/dist/ng-pable.min.js', 'resources/vendor/ng-table/dist/ng-pable.min.css']
    }, {
        name: 'ui.select',
        files: ['resources/vendor/angular-ui-select/dist/select.min.js', 'resources/vendor/angular-ui-select/dist/select.min.css',
                'resources/vendor/select2/dist/css/select2.min.css', 'resources/vendor/select2-bootstrap-css/select2-bootstrap.min.css',
                'resources/vendor/selectize/dist/css/selectize.bootstrap3.css']
    }, {
        name: 'ui.mask',
        files: ['resources/vendor/angular-ui-utils/mask.min.js']
    }, {
        name: 'ngImgCrop',
        files: ['resources/vendor/ngImgCrop/compile/minified/ng-img-crop.js', 'resources/vendor/ngImgCrop/compile/minified/ng-img-crop.css']
    }, {
        name: 'angularFileUpload',
        files: ['resources/vendor/angular-file-upload/angular-file-upload.min.js']
    }, {
        name: 'ngAside',
        files: ['resources/vendor/angular-aside/dist/js/angular-aside.min.js', 'resources/vendor/angular-aside/dist/css/angular-aside.min.css']
    }, {
        name: 'truncate',
        files: ['resources/vendor/angular-truncate/src/truncate.js']
    }, {
        name: 'oitozero.ngSweetAlert',
        files: ['resources/vendor/angular-sweetalert-promised/SweetAlert.min.js']
    }, {
        name: 'monospaced.elastic',
        files: ['resources/vendor/angular-elastic/elastic.js']
    }, {
        name: 'ngMap',
        files: ['resources/vendor/ngmap/build/scripts/ng-map.min.js']
    }, {
        name: 'tc.chartjs',
        files: ['resources/vendor/tc-angular-chartjs/dist/tc-angular-chartjs.min.js']
    }, {
        name: 'flow',
        files: ['resources/vendor/ng-flow/dist/ng-flow-standalone.min.js']
    }, {
        name: 'uiSwitch',
        files: ['resources/vendor/angular-ui-switch/angular-ui-switch.min.js', 'resources/vendor/angular-ui-switch/angular-ui-switch.min.css']
    }, {
        name: 'ckeditor',
        files: ['resources/vendor/angular-ckeditor/angular-ckeditor.min.js']
    }, {
        name: 'mwl.calendar',
        files: ['resources/vendor/angular-bootstrap-calendar/dist/js/angular-bootstrap-calendar.js',
                'resources/vendor/angular-bootstrap-calendar/dist/js/angular-bootstrap-calendar-tpls.js',
                'resources/vendor/angular-bootstrap-calendar/dist/css/angular-bootstrap-calendar.min.css']
    }, {
        name: 'ng-nestable',
        files: ['resources/vendor/ng-nestable/src/angular-nestable.js']
    }, {
        name: 'vAccordion',
        files: ['resources/vendor/v-accordion/dist/v-accordion.min.js', 'resources/vendor/v-accordion/dist/v-accordion.min.css']
    }, {
        name: 'xeditable',
        files: ['resources/vendor/angular-xeditable/dist/js/xeditable.min.js', 'resources/vendor/angular-xeditable/dist/css/xeditable.css',
                'resources/js/config/config-xeditable.js']
    }, {
        name: 'checklist-model',
        files: ['resources/vendor/checklist-model/checklist-model.js']
    }, {
        name: 'alasql',
        files: ['resources/vendor/alasql/dist/alasql.min.js']
    },{
        name: 'xls',
        files: ['resources/vendor/xls/dist/xls.core.min.js']
    },{
        name: 'xlsx',
        files: ['resources/vendor/xlsx/dist/xlsx.core.min.js']
    },{
        name: 'placeholder',
        files: ['resources/vendor/placeholder/placeholders.min.js']
    }, {
        name: 'ui.tree',
        files: ['resources/vendor/angular-ui-tree/angular-ui-tree.min.js', 'resources/vendor/angular-ui-tree/app.css', 'resources/vendor/angular-ui-tree/angular-ui-tree.min.css']
    }, {
        name: 'angularjs-dropdown-multiselect',
        files: ['resources/vendor/angularjs-dropdown-multiselect/angularjs-dropdown-multiselect.min.js']
    }, {
        name: 'InlineTextEditor',
        files: ['resources/vendor/ite/ite.js', 'resources/vendor/ite/ite.css']
    }, {
        name: 'ngSanitize',
        files: ['resources/vendor/angular-sanitize/angular-sanitize.js']
    }
    ]
});
