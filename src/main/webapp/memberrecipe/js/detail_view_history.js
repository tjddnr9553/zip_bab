let rView = JSON.parse(localStorage.getItem('rView')) || []
const recipeId = document.body.dataset.recipeId
const recipeImg = document.body.dataset.recipeImg


const newItem = { id: recipeId, img: recipeImg }
const existingItemIndex = rView.findIndex((item) => item.id === recipeId);

console.log(existingItemIndex)
if (existingItemIndex === -1) { // 없을 때
    if (rView.length > 9) {
        rView.pop()
    }
} else { // 있을 때
    rView.splice(existingItemIndex, 1)
}
rView.unshift(newItem)
localStorage.setItem('rView', JSON.stringify(rView))

let vhDiv = document.getElementById('viewHistory')
let rViewLen = Math.min(rView.length, 5)
for (i = 0; i < rViewLen; i++) {
    let newDiv = document.createElement('div')
    newDiv.style.width = '100px'
    newDiv.style.height = '100px'
    let newImg = document.createElement('img')
    newImg.setAttribute('src', rView[i].img)
    newImg.classList.add("img-fluid")
    newDiv.appendChild(newImg)
    vhDiv.appendChild(newDiv)
}