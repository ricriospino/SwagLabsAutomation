const report = require("multiple-cucumber-html-reporter");

report.generate({
  jsonDir: './test/report/',
  reportPath: './test/report/',
  staticFilePath : false,
  openReportInBrowser : true,
  pageTitle : 'Reporte Para Swaglabs',
  plainDescription : true,
  plainDescription : true ,
  displayDuration: true ,
  hideMetadata : false ,
  
  metadata: {
    browser: {
      name: "chrome",
      version: "115",
    },
    device: "Maquina Local",
    platform: {
      name: "Windows",
      version: "10",
    },
  },
  customData: {
    title: "Web: Swaglabs TestSuit",
    data: [
      { label: "Project", value: "Swaglabs validacion prueba UAT EN GUI" },
      { label: "Release", value: "1.0" },
      { label: "Cycle", value: "1" },
      { label: "Execution Start Time", value: "sábado, 12 de agosto de 2023" },
      { label: "Execution End Time", value: "sábado, 12 de agosto de 2023" },
    ],
  },
});