//  ========== Take A Tour =============

const btnOpenVideo = document.querySelector('.player-play');
const islandsPopup = document.getElementById('popup');

function poPup(){
    islandsPopup.classList.add('show-popup');
}

btnOpenVideo.addEventListener('click', poPup);

// btnOpenVideo.forEach(b => b.addEventListener('click', poPup));

const btnCloseVideo = document.getElementById('play__close');

btnCloseVideo.addEventListener('click', () =>{
    islandsPopup.classList.remove('show-popup');
})

// ============ Guests ===============
new Swiper(".swiper-container", {
    slidersPerView: 3,
    spaceBetween: 30,
    autoPlay: {
        delay: 2500,
        pauseOnMouseEnter: true
    },
    panigation: {
        el: ".swiper-pagination",
        clickable: true
    },
});


// ========== slider number ==========
const counters = document.querySelectorAll('.counter');

counters.forEach(counter => {
    counter.innerText = '0';

    const updateCounter = () => {
        const target = +counter.getAttribute('data-target');
        const c = +counter.innerText;

        const increment = target / 200;

        if(c < target) {
            counter.innerText = `${Math.ceil(c + increment)}`;
            setTimeout(updateCounter, 1000);
        } else {
            counter.innerText = target;
        }
    }

    updateCounter();
});

/*==================== SHOW MENU ====================*/
const showMenu = (toggleId, navId) =>{
    const toggle = document.getElementById(toggleId),
    nav = document.getElementById(navId)
    
    // Validate that variables exist
    if(toggle && nav){
        toggle.addEventListener('click', ()=>{
            // We add the show-menu class to the div tag with the nav__menu class
            nav.classList.toggle('show-menu')
        })
    }
}
showMenu('nav-toggle','nav-menu');

