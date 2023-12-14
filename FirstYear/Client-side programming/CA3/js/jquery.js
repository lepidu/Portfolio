
/* Part 1: Get Password */

const pass = document.getElementById("password")
const form = document.getElementById("form")
const section = document.getElementById("warnings")

form.addEventListener("submit", e=>{
    e.preventDefault()
    let warnings =""
    let input = false

    /* Make Regex */
    let regExp = new RegExp ("^(?=.*[A-Z])+^(?=.*[a-z])+^(?=.*[0-9])+^(?=.*[!#$%&/*.])")
    section.innerHTML =""
    if(!regExp.test(pass.value)){
        warnings += `You must enter 8 digits, a number, a special character, a upper and lowercase <br>`
        input = true
    }
    else if(pass.value.length < 8){
        warnings += `Invalid password you must enter 8 digits <br>`
        input = true
    }

    if(input){
        section.innerHTML = warnings
    }else{
        section.innerHTML = "Password complete"
    }

})

/* Part 2: Get Users */


document.getElementById('getUsers').addEventListener('click', getUsers);

/* Import data from JSON users */
function getUsers() {
    fetch('https://randomuser.me/api/?results=5')
        .then((res) => res.json())
        .then((data) => {
            let author = data.results;
            let output = ''
            console.log(data);
            author.forEach(function (user) {
                output +=
                    
                    `
            <div>
             
                <h2>Name: ${user.name.first} <img align=right src="${user.picture.medium}"></h2><br> 
                <p>Phone Number: ${user.phone}</p>
                <p> Date of Birth: ${user.dob.date}</p>
                <p>Age: ${user.dob.age} </p>
                <p>Email: ${user.email}</p>
                <p>Gender: ${user.gender} </p>
                <p>City: ${user.location.city} </p>
                <p>Country: ${user.location.country} </p>
                <p>Post Code: ${user.location.postcode} </p>
                <br><br> 
            </div>
            `;
            });
            document.getElementById('output').innerHTML = output;

        })
}

/* Part 3: Get Bills */

var total_items = 19;
   
function getBill(){
    let total = 0;
    let total_starter = 0;
    let total_main = 0;
    let total_dessert = 0;
    let total_drink = 0;
    let total_veg = 0;
    let total_noVeg = 0;

    /* Loop for catch variables */
   
    for (let i = 1; i <= total_items; i++) {
       itemID =document.getElementById("qnt_" + i);
       total = total + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    
    if(itemID.className=="starters"){
      total_starter = total_starter + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    };
    if(itemID.className=="main"){
      total_main = total_main + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    }; 
    if(itemID.className=="dess"){
      total_dessert = total_dessert + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    }; 
    if(itemID.className=="drinks"){
      total_drink = total_drink + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    };
    if(itemID == qnt_1 || itemID == qnt_3 || itemID == qnt_7 || itemID == qnt_9){
      total_veg = total_veg + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    }
    if(itemID.className=="main" || itemID.className=="starters"){
      total_noVeg = total_noVeg + parseInt(itemID.value) * parseInt(itemID.getAttribute("data-price"));
    }

  }
  
 document.getElementById('total_bill').innerHTML = "€ " + total +".00";
 document.getElementById('starters').innerHTML = "€" + total_starter +".00";
 document.getElementById('main').innerHTML = "€" + total_main + ".00";
 document.getElementById('dessert').innerHTML = "€" + total_dessert + ".00";
 document.getElementById('drinks').innerHTML = "€" + total_drink + ".00";
 document.getElementById('veg_cost').innerHTML = "€" + total_veg + ".00";
 document.getElementById('non_veg').innerHTML = "€" + total_noVeg + ".00";      
 }

/* Output the value*/
    document.getElementById("getCost").addEventListener('click', getBill); 

