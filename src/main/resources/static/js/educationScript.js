document.addEventListener('DOMContentLoaded', () => {
	const registerButton = document.getElementById('choice-btn');
	//const errorMessageDiv = document.getElementById('errorMessage');
	const education = document.getElementById('education');
	const bar = document.getElementById('file');
	const selectedValue = document.getElementById('degree');
	let selectValue = selectedValue.value;
	selectedValue.addEventListener('change', (event) => {
		selectValue = event.target.value;
		console.log(selectValue);
		if (selectValue !== "Enter a different degree") {
			degree = selectValue;
			console.log(selectValue);
		}
		else {
			const other = document.getElementById('other').value;
			const another = document.getElementById('differentDegree');
			another.classList.remove("hide");
			degree = other;
		}
	});
	
	registerButton.addEventListener('click', async () => {
		const schoolName = document.getElementById('schoolName').value;
		const schoolLocation = document.getElementById('schoolLocation').value;
		
		const cgpa = document.getElementById('cgpa').value;

		const data = { schoolName, schoolLocation, degree, cgpa};
        
		try {
			const response = await fetch('updateEducation', {
				method: 'PATCH',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(data)
			});

			if (!response.ok) {
				const errorData = await response.json();
				alert(errorData.message || 'An error occurred. Please try again.');
			} else {
				console.log("success");
			    education.checked = true;
				bar.value = "28";
				window.location.href='experience';
				// Optionally, redirect or perform any other action after a successful update
			}
		} catch (error) {
			alert('An error occurred. Please try again.');
		}
	});
});