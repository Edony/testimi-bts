import {Injectable} from '@angular/core';

export interface BadgeItem {
  type: string;
  value: string;
}

export interface ChildrenItems {
  state: string;
  target?: boolean;
  name: string;
  type?: string;
  children?: ChildrenItems[];
}

export interface MainMenuItems {
  state: string;
  short_label?: string;
  main_state?: string;
  target?: boolean;
  name: string;
  type: string;
  icon: string;
  badge?: BadgeItem[];
  children?: ChildrenItems[];
}

export interface Menu {
  label: string;
  main: MainMenuItems[];
}

const MENUITEMS = [
  {
    label: 'Porosit Online',
    main: [
      {
        state: 'blej-produkte',
        short_label: 'S',
        name: 'Produktet',
        type: 'link',
        icon: 'ti-layout-grid2'
      },
      {
        state: 'shporta',
        short_label: 'SH',
        name: 'Shporta',
        type: 'link',
        icon: 'ti-shopping-cart'
      },
      {
        state: 'lista-porosive',
        short_label: 'LS',
        name: 'Lista Porosive',
        type: 'link',
        icon: 'ti-layout-list-thumb'
      },
      {
        state: 'stoku',
        short_label: 'S',
        name: 'Stoku',
        type: 'link',
        icon: 'ti-truck'
      },
    ]
  }
];

@Injectable()
export class MenuItems {
  getAll(): Menu[] {
    return MENUITEMS;
  }
}
