"use strict";
const parentMarquee = document.querySelector(".marquee-wrapper");
const childMarquee = document.querySelector(".marquee-content");
// will clone the child node of Parent Marquee or copy the sibling
const adChildMarquee = document
  .querySelector(".marquee-content")
  .cloneNode(true);
parentMarquee.appendChild(adChildMarquee);
// code below will allow a draggable feature for the marquee carousel
const ulParentListContainer = document.querySelector(".marquee-wrapper");
let isDragging = false;
const dragStart = (e) => {
  if (!isDragging) return;
  ulParentListContainer.scrollLeft -= e.movementX;
};
const stopDragging = () => {
  isDragging = false;
};
// when mouse is pressed
ulParentListContainer.addEventListener("mousedown", () => (isDragging = true));
// when mouse is move to left
ulParentListContainer.addEventListener("mousemove", dragStart);
// when mouse pressed is released
window.addEventListener("mouseup", stopDragging);
