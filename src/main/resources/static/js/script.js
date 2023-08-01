function redirectEmployee(id) {
    return window.location.href = '/employee/' + id;
}
function redirectEmployeeToEdit(id) {
    return window.location.href = '/employee/' + id+'/edit';
}

function submitForm() {
    // Supprimer les champs de saisie dont la valeur est null avant de soumettre le formulaire
    const firstNameInput = document.querySelector('input[name="firstName"]');
    const lastNameInput = document.querySelector('input[name="lastName"]');
    const jobFunctionInput = document.querySelector('input[name="jobFunction"]');
    const entranceInput = document.querySelector('input[name="entrance"]');
    const code = document.querySelector('input[name="code"]');
    const departureInput = document.querySelector('input[name="departure"]');
    const sexSelect = document.getElementById('sex');
    const sortSelect = document.getElementById('criteria');
    const   sortorderSelect = document.getElementById('sortOrder');
    if (sortSelect && firstNameInput.value === ''|| sortSelect.value==="null") {
        sortSelect.disabled = true;
    }
    if (sortorderSelect && firstNameInput.value === ''|| sortorderSelect.value==="null") {
        sortorderSelect  .disabled = true;
    }

    if (firstNameInput && firstNameInput.value === ''|| firstNameInput.value==="null") {
        firstNameInput.disabled = true;
    }

    if (lastNameInput && lastNameInput.value === '' || lastNameInput.value==="null") {
        lastNameInput.disabled = true;
    }

    if (jobFunctionInput && jobFunctionInput.value === ''|| jobFunctionInput.value==="null") {
        jobFunctionInput.disabled = true;
    }

    if (entranceInput && entranceInput.value === ''|| entranceInput.value==="null") {
        entranceInput.disabled = true;
    }

    if (departureInput && departureInput.value === ''|| departureInput.value==="null") {
        departureInput.disabled = true;
    }
    if (code && code.value === ''|| code.value==="null") {
        code.disabled = true;
    }

    if (sexSelect && sexSelect.value === '' || sexSelect.value==="null") {
        sexSelect.disabled = true;
    }
}
function extractBase64FromSrc(src) {
    // Extract the base64 value from the src attribute
    var startIndex = src.indexOf('base64,') + 7;
    return src.substring(startIndex);
}

function exportToCSV() {
    var csvContent = "data:text/csv;charset=utf-8,";
    var table = document.querySelector("table");
    var rows = table.querySelectorAll("tr");

    // Add table headers to CSV content
    var headers = table.querySelectorAll("th");
    var headerRow = [];
    headers.forEach(function (header) {
        headerRow.push(header.innerText);
    });
    csvContent += headerRow.join(",") + "\n";

    rows.forEach(function (row) {
        var rowData = [];
        var columns = row.querySelectorAll("td");

        columns.forEach(function (column) {
            // Exclude the buttons
            if (column.classList.contains("exclude-from-csv")) {
                return; // Skip this column
            }

            // Extract the base64 value from the image src
            var imageElement = column.querySelector("img");
            if (imageElement) {
                rowData.push(extractBase64FromSrc(imageElement.getAttribute("src")));
            } else {
                rowData.push(column.innerText);
            }
        });

        // Include rowData in the CSV content only if it is not empty
        if (rowData.length > 0) {
            csvContent += rowData.join(",") + "\n";
        }
    });

    var encodedUri = encodeURI(csvContent);
    var link = document.getElementById("exportLink");
    link.setAttribute("href", encodedUri);
    link.click();
}