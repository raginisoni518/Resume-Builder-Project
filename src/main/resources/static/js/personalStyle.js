document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('choice-btn');
    const errorMessageDiv = document.getElementById('errorMessage');
     const personalDetails = document.getElementById('personalDetails');
     const bar = document.getElementById('file');
    registerButton.addEventListener('click', async () => {
        const email = document.getElementById('email').value;
        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const profession = document.getElementById('profession').value;
        const city = document.getElementById('city').value;
         const country = document.getElementById('country').value;
          const pin = document.getElementById('pin').value;
           const phone = document.getElementById('phone').value;

        const data = { email, firstName, lastName, profession, city, country, pin, phone };

        try {
            const response = await fetch('update', {
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
               window.location.href = 'education'; 
                personalDetails.checked=true;
                bar.value="16";
                // Optionally, redirect or perform any other action after a successful update
            }
        } catch (error) {
            alert('An error occurred. Please try again.');
        }
    });
});