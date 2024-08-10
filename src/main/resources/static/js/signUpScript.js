document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('register-btn');
    registerButton.addEventListener('click', async () => {
        const email = document.getElementById('email').value;
        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
       const password=document.getElementById('password').value;

        const data = { firstName, lastName,email, password };

        try {
            const response = await fetch('save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (!response.ok) {
                const errorData = await response.json();
                alert(errorData.message || 'Email already exist');
            } else {
				console.log("success");
               window.location.href = 'signIn'; 
               
            }
        } catch (error) {
            alert('An error occurred. Please try again.');
        }
    });
});
 