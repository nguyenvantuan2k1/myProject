// ------------- All Rooms ------------
const toggles = document.querySelectorAll('.faq-toggle')

toggles.forEach(toggle => {
    toggle.addEventListener('click', () => {
        toggle.parentNode.classList.toggle('active')
    })
})

// ------------ Giá -----------
const range = document.getElementById('range')

range.addEventListener('input', (e) => {
    const value = +e.target.value
    const label = e.target.nextElementSibling

    const range_width = getComputedStyle(e.target).getPropertyValue('width')
    const label_width = getComputedStyle(label).getPropertyValue('width')

    const num_width = +range_width.substring(0, range_width.length - 2)
    const num_label_width = +label_width.substring(0, label_width.length - 2)

    const max = +e.target.max
    const min = +e.target.min

    const left = value * (num_width / max) - num_label_width / 2 + scale(value, min, max, 10, -10)

    label.style.left = `${left}px`


    label.innerHTML = value
})

// https://stackoverflow.com/questions/10756313/javascript-jquery-map-a-range-of-numbers-to-another-range-of-numbers
const scale = (num, in_min, in_max, out_min, out_max) => {
    return (num - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
}

// ----------------- Tiện ích -----------------
// const toggle = document.querySelectorAll('.toggle')
// const wc = document.querySelector('#wc')
// const parking = document.querySelector('#parking')
// const window = document.querySelector('#window')
// const security = document.querySelector('#security')
// const wifi = document.querySelector('#wifi')
// const free = document.querySelector('#free')
// const ownowner = document.querySelector('#ownowner')
// const condition = document.querySelector('#condition')
// const waterHeater = document.querySelector('#waterHeater')
// const kitchen = document.querySelector('#kitchen')
// const refrigerator = document.querySelector('#refrigerator')
// const washing = document.querySelector('#washing')
// const mezzanine = document.querySelector('#mezzanine')
// const bed = document.querySelector('#bed')
// const wardrobe = document.querySelector('#wardrobe')
// const tivi = document.querySelector('#tivi')
// const pet = document.querySelector('#pet')

// toggle.forEach(toggle => toggle.addEventListener('change', (e) => doTheTrick(e.target)))

// function doTheTrick(theClickedOne) {
//     if(good.checked && cheap.checked && fast.checked) {
//         if(wc === theClickedOne) {
//             fast.checked = false
//         }

//         if(cheap === theClickedOne) {
//             good.checked = false
//         }

//         if(fast === theClickedOne) {
//             cheap.checked = false
//         }
//     }
// }